package com.furkanisitan.moviecatalog.business.concretes;

import com.furkanisitan.moviecatalog.business.abstracts.ActorService;
import com.furkanisitan.moviecatalog.business.abstracts.MovieService;
import com.furkanisitan.moviecatalog.business.validationrules.fluentvalidator.MovieValidator;
import com.furkanisitan.moviecatalog.core.aspects.annotations.FluentValidator;
import com.furkanisitan.moviecatalog.dataaccess.abstracts.MovieActorRepository;
import com.furkanisitan.moviecatalog.dataaccess.abstracts.MovieRepository;
import com.furkanisitan.moviecatalog.entities.complexresults.CharacterDetailForMovieResult;
import com.furkanisitan.moviecatalog.entities.complexresults.MovieIdNameResult;
import com.furkanisitan.moviecatalog.entities.complexresults.MovieListResult;
import com.furkanisitan.moviecatalog.entities.concretes.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class MovieManager implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieActorRepository movieActorRepository;
    private final ActorService actorService;

    @Autowired
    public MovieManager(MovieRepository movieRepository, MovieActorRepository movieActorRepository, ActorService actorService) {
        this.movieRepository = movieRepository;
        this.movieActorRepository = movieActorRepository;
        this.actorService = actorService;
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    @Override
    public List<CharacterDetailForMovieResult> getAllCharacterDetailForMovieResult(int id) {
        return movieActorRepository.getAllCharacterDetailForMovieResult(id);
    }

    @Override
    public Optional<Movie> getWithGenresAndLanguages(int id) {
        return movieRepository.getById(id);
    }

    @Override
    public List<MovieListResult> getAllMovieListResult() {
        return movieRepository.customGetAllMovieListResult();
    }

    @Override
    public List<MovieIdNameResult> getAllMovieIdNameResult() {
        return movieRepository.getAllSelectIdAndName();
    }

    @Override
    public Optional<Movie> get(int id) {
        return movieRepository.getById(id);
    }

    @FluentValidator(MovieValidator.class)
    @Override
    public int create(Movie movie) {
        return movieRepository.save(movie).getId();
    }

    @FluentValidator(MovieValidator.class)
    @Override
    public void update(Movie movie) {
        var actors = actorService.getAllByMovieId(movie.getId());
        movie.setActors(new HashSet<>(actors));
        movieRepository.save(movie);
    }

    @RolesAllowed("ADMIN")
    @Override
    public void delete(Movie movie) {
        movieRepository.delete(movie);
    }
}
