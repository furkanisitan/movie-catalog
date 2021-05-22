package com.furkanisitan.moviecatalog.business.abstracts;

import com.furkanisitan.moviecatalog.entities.complexresults.MovieIdNameResult;
import com.furkanisitan.moviecatalog.entities.complexresults.MovieListResult;
import com.furkanisitan.moviecatalog.entities.concretes.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAll();

    List<MovieListResult> getAllMovieListResult();

    List<MovieIdNameResult> getAllMovieIdNameResult();
}
