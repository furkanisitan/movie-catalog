package com.furkanisitan.moviecatalog.webmvc.controllers;

import com.furkanisitan.moviecatalog.business.abstracts.GenreService;
import com.furkanisitan.moviecatalog.entities.concretes.Genre;
import com.furkanisitan.moviecatalog.webmvc.dtos.genre.GenreDto;
import com.furkanisitan.moviecatalog.webmvc.exceptions.ResourceNotFoundException;
import com.furkanisitan.moviecatalog.webmvc.helpers.MapperHelper;
import com.furkanisitan.moviecatalog.webmvc.utils.ServiceWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("genres")
public class GenreController {

    private static final String genreDtoAttr = "genreDto";
    private static final String showModalAttr = "showModal";

    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping({"", "/index"})
    public String index(Model model) {

        if (!model.containsAttribute(genreDtoAttr))
            model.addAttribute(genreDtoAttr, new GenreDto());

        var genreDtoList = MapperHelper.mapList(genreService.getAll(), GenreDto.class);
        model.addAttribute("genres", genreDtoList);

        return "genre/index";
    }

    @PostMapping("/create")
    public String create(@Valid final GenreDto genreDto, final BindingResult result, final RedirectAttributes attributes) {

        genreDto.setId(0);

        var wrapper = ServiceWrapper.of(() -> genreService.create(MapperHelper.map(genreDto, Genre.class)), result, genreDtoAttr);

        if (wrapper.isFailure()) {
            attributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + genreDtoAttr, result);
            attributes.addFlashAttribute(genreDtoAttr, genreDto);
            attributes.addFlashAttribute(showModalAttr, "create");
        }

        return "redirect:/genres/index";
    }

    @PostMapping("/update")
    public String update(@Valid final GenreDto genreDto, final BindingResult result, final RedirectAttributes attributes) {

        var wrapper = ServiceWrapper.of(() -> genreService.update(MapperHelper.map(genreDto, Genre.class)), result, genreDtoAttr);

        if (wrapper.isFailure()) {
            attributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + genreDtoAttr, result);
            attributes.addFlashAttribute(genreDtoAttr, genreDto);
            attributes.addFlashAttribute(showModalAttr, "update");
        }

        return "redirect:/genres/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {

        var genre = genreService.get(id).orElseThrow(() -> new ResourceNotFoundException("Invalid genre Id:" + id));
        genreService.delete(genre);

        return "redirect:/genres/index";
    }

}
