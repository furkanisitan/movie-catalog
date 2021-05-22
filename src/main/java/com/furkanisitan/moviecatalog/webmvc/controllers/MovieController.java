package com.furkanisitan.moviecatalog.webmvc.controllers;


import com.furkanisitan.moviecatalog.business.abstracts.MovieService;
import com.furkanisitan.moviecatalog.webmvc.dtos.actor.ActorDto;
import com.furkanisitan.moviecatalog.webmvc.exceptions.ResourceNotFoundException;
import com.furkanisitan.moviecatalog.webmvc.helpers.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping({"", "/index"})
    public String index(Model model) {

        var movieListResults = movieService.getAllMovieListResult();
        model.addAttribute("movieListResults", movieListResults);

        return "movie/index";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable int id, Model model) {

        var movie = movieService.getWithGenresAndLanguages(id).orElseThrow(() -> new ResourceNotFoundException("Invalid movie Id:" + id));
        var characterDetailResults = movieService.getAllCharacterDetailForMovieResult(id);

        model.addAttribute("movie", movie);
        model.addAttribute("characterDetailResults", characterDetailResults);

        return "movie/detail";
    }
}
