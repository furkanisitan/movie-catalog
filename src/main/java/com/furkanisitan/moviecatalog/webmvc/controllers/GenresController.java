package com.furkanisitan.moviecatalog.webmvc.controllers;

import com.furkanisitan.moviecatalog.business.abstracts.GenreService;
import com.furkanisitan.moviecatalog.entities.concretes.Genre;
import com.furkanisitan.moviecatalog.webmvc.dtos.genres.GenreDto;
import com.furkanisitan.moviecatalog.webmvc.helpers.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String showGenreList(Model model, GenreDto genreDto) {

        var genreDtoList = MapperHelper.mapList(genreService.getAll(), GenreDto.class);
        genreDtoList.sort(Comparator.comparing(GenreDto::getName, String.CASE_INSENSITIVE_ORDER));

        model.addAttribute("genres", genreDtoList);

        return "genres/index";
    }

    @PostMapping("/create")
    public String createGenre(GenreDto genreDto, BindingResult bindingResult) {

        genreDto.setId(0);
        genreService.save(MapperHelper.map(genreDto, Genre.class));

        return "redirect:/genres/index";
    }

    @PostMapping("/update")
    public String updateGenre(GenreDto genreDto, BindingResult bindingResult) {

        genreService.update(MapperHelper.map(genreDto, Genre.class));
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
