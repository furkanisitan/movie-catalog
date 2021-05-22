package com.furkanisitan.moviecatalog.webmvc.controllers;


import com.furkanisitan.moviecatalog.business.abstracts.GenreService;
import com.furkanisitan.moviecatalog.business.abstracts.LanguageService;
import com.furkanisitan.moviecatalog.business.abstracts.MovieService;
import com.furkanisitan.moviecatalog.entities.concretes.Movie;
import com.furkanisitan.moviecatalog.webmvc.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("movies")
public class MovieController {

    private final MovieService movieService;
    private final GenreService genreService;
    private final LanguageService languageService;

    @Autowired
    public MovieController(MovieService movieService, GenreService genreService, LanguageService languageService) {
        this.movieService = movieService;
        this.genreService = genreService;
        this.languageService = languageService;
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

    @GetMapping("/create")
    public String create(Movie movie, Model model) {

        model.addAttribute("genres", genreService.getAll());
        model.addAttribute("languages", languageService.getAll());

        return "movie/create";
    }

    @PostMapping("/create")
    public String create(@Valid Movie movie, Model model, BindingResult result) {

        if (result.hasErrors()) {
            return "movie/create";
        }

        return "redirect:movies/update/" + movie.getId();
    }
}
