package com.furkanisitan.moviecatalog.business.abstracts;

import com.furkanisitan.moviecatalog.entities.complexresults.CharacterDetailForMovieResult;
import com.furkanisitan.moviecatalog.entities.complexresults.MovieIdNameResult;
import com.furkanisitan.moviecatalog.entities.complexresults.MovieListResult;
import com.furkanisitan.moviecatalog.entities.concretes.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<Movie> getAll();

    List<CharacterDetailForMovieResult> getAllCharacterDetailForMovieResult(int id);

    Optional<Movie> getWithGenresAndLanguages(int id);

    List<MovieListResult> getAllMovieListResult();

    List<MovieIdNameResult> getAllMovieIdNameResult();

    int create(Movie movie);

    void update(Movie movie);

    void delete(Movie movie);
}
