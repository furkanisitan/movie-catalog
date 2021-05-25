package com.furkanisitan.moviecatalog.webmvc.controllers;


import com.furkanisitan.moviecatalog.business.abstracts.ActorService;
import com.furkanisitan.moviecatalog.business.abstracts.GenreService;
import com.furkanisitan.moviecatalog.business.abstracts.LanguageService;
import com.furkanisitan.moviecatalog.business.abstracts.MovieService;
import com.furkanisitan.moviecatalog.entities.concretes.Movie;
import com.furkanisitan.moviecatalog.webmvc.dtos.actor.CharacterDto;
import com.furkanisitan.moviecatalog.webmvc.exceptions.ResourceNotFoundException;
import com.furkanisitan.moviecatalog.webmvc.utils.Constants;
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

import javax.annotation.security.RolesAllowed;

@Controller
@RequestMapping("movies")
public class MovieController {

    private final MovieService movieService;
    private final ActorService actorService;
    private final GenreService genreService;
    private final LanguageService languageService;

    @Autowired
    public MovieController(MovieService movieService, ActorService actorService, GenreService genreService, LanguageService languageService) {
        this.movieService = movieService;
        this.actorService = actorService;
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

        model.addAttribute(Constants.ModelAttr.MOVIE, movie);
        model.addAttribute("characterDetailResults", characterDetailResults);

        return "movie/detail";
    }

    @GetMapping("/create")
    public String create(Model model) {

        if (!model.containsAttribute(Constants.ModelAttr.MOVIE))
            model.addAttribute(Constants.ModelAttr.MOVIE, new Movie());

        model.addAttribute("genres", genreService.getAll());
        model.addAttribute("languages", languageService.getAll());

        return "movie/create";
    }

    @PostMapping("/create")
    public String create(Movie movie, BindingResult result, RedirectAttributes attributes) {

        var wrapper = ServiceWrapper.of(() -> movieService.create(movie), result, "movie");

        if (wrapper.isFailure()) {
            attributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + Constants.ModelAttr.MOVIE, result);
            attributes.addFlashAttribute(Constants.ModelAttr.MOVIE, movie);
            return "redirect:/movies/create";
        }

        return "redirect:/movies/update/" + movie.getId();
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model) {

        var movie = movieService.get(id).orElseThrow(() -> new ResourceNotFoundException("Invalid movie Id:" + id));

        if (!model.containsAttribute(Constants.ModelAttr.CHARACTER_DTO))
            model.addAttribute(Constants.ModelAttr.CHARACTER_DTO, new CharacterDto());

        model.addAttribute(Constants.ModelAttr.MOVIE, movie);
        model.addAttribute("actors", actorService.getAll());
        model.addAttribute("genres", genreService.getAll());
        model.addAttribute("languages", languageService.getAll());
        model.addAttribute("characterDetailResults", movieService.getAllCharacterDetailForMovieResult(id));

        return "movie/update";
    }

    @PostMapping("/update/{id}")
    public String update(Movie movie, BindingResult result, RedirectAttributes attributes) {

        var wrapper = ServiceWrapper.of(() -> movieService.update(movie), result, "movie");
        return wrapper.isFailure() ? "movie/update" : "redirect:/movies/update/" + movie.getId();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {

        var actor = movieService.get(id).orElseThrow(() -> new ResourceNotFoundException("Invalid movie Id:" + id));
        movieService.delete(actor);

        return "redirect:/movies";
    }
}
