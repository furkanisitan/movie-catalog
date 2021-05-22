package com.furkanisitan.moviecatalog.webmvc.controllers;


import com.furkanisitan.moviecatalog.business.abstracts.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
