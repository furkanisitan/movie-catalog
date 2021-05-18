package com.furkanisitan.moviecatalog.webmvc.controllers;

import com.furkanisitan.moviecatalog.business.abstracts.GenreService;
import com.furkanisitan.moviecatalog.webmvc.dtos.genres.GenreDto;
import com.furkanisitan.moviecatalog.webmvc.helpers.MapperHelper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("genres")
public class GenresController {

    private GenreService genreService;

    @Autowired
    public GenresController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("")
    public String showGenreList(Model model) {

        var genreDtoList = MapperHelper.mapList(new ArrayList<GenreDto>(), GenreDto.class);


        model.addAttribute("genres", genreDtoList);

        return "genres/index";
    }

}
