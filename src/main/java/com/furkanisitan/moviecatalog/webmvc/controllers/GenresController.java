package com.furkanisitan.moviecatalog.webmvc.controllers;

import com.furkanisitan.moviecatalog.business.abstracts.GenreService;
import com.furkanisitan.moviecatalog.webmvc.dtos.genres.GenreDto;
import com.furkanisitan.moviecatalog.webmvc.helpers.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Comparator;

@Controller
@RequestMapping("genres")
public class GenresController {

    private final GenreService genreService;

    @Autowired
    public GenresController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping({"", "/index"})
    public String showList(Model model) {

        if (!model.containsAttribute("genreDto")) {
            model.addAttribute("genreDto", new GenreDto());
            model.addAttribute("showModal", "none");
        }

        var genreDtoList = MapperHelper.mapList(genreService.getAll(), GenreDto.class);
        genreDtoList.sort(Comparator.comparing(GenreDto::getName, String.CASE_INSENSITIVE_ORDER));
        model.addAttribute("genres", genreDtoList);

        return "genres/index";
    }

    @PostMapping("/create")
    public String createGenre(@Valid GenreDto genreDto,
                              final BindingResult result,
                              final RedirectAttributes attributes) {

        if (result.hasErrors()) {
            attributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "genreDto", result);
            attributes.addFlashAttribute("genreDto", genreDto);
            attributes.addFlashAttribute("showModal", "create");
        }
        return "redirect:/genres/index";
    }

    @PostMapping("/update")
    public String updateGenre(@Valid final GenreDto genreDto,
                              final BindingResult result,
                              final RedirectAttributes attributes) {

        //genreService.update(MapperHelper.map(genreDto, Genre.class));

        if (result.hasErrors()) {
            attributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "genreDto", result);
            attributes.addFlashAttribute("genreDto", genreDto);
            attributes.addFlashAttribute("showModal", "update");
        }

        return "redirect:/genres/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {

        var genre = genreService.get(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        genreService.delete(genre);

        return "redirect:/genres/index";
    }

}
