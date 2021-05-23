package com.furkanisitan.moviecatalog.webmvc.controllers;


import com.furkanisitan.moviecatalog.business.abstracts.GenreService;
import com.furkanisitan.moviecatalog.business.abstracts.LanguageService;
import com.furkanisitan.moviecatalog.business.abstracts.MovieService;
import com.furkanisitan.moviecatalog.entities.concretes.Movie;
import com.furkanisitan.moviecatalog.webmvc.exceptions.ResourceNotFoundException;
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
@RequestMapping("movies")
public class MovieController {

    private static final String movieAttr = "movie";


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

        model.addAttribute(movieAttr, movie);
        model.addAttribute("characterDetailResults", characterDetailResults);

        return "movie/detail";
    }

    @GetMapping("/create")
    public String create(Model model) {

        if (!model.containsAttribute(movieAttr))
            model.addAttribute(movieAttr, new Movie());

        model.addAttribute("genres", genreService.getAll());
        model.addAttribute("languages", languageService.getAll());

        return "movie/create";
    }

    @PostMapping("/create")
    public String create(@Valid Movie movie, BindingResult result, RedirectAttributes attributes) {

        var wrapper = ServiceWrapper.of(() -> movieService.create(movie), result, "movie");

        if (wrapper.isFailure()) {
            attributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + movieAttr, result);
            attributes.addFlashAttribute(movieAttr, movie);
            return "redirect:/movies/create";
        }

        return "redirect:/movies";
    }
}
