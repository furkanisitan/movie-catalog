package com.furkanisitan.moviecatalog.business.concretes;

import com.furkanisitan.moviecatalog.business.abstracts.GenreService;
import com.furkanisitan.moviecatalog.business.validationrules.fluentvalidator.GenreValidator;
import com.furkanisitan.moviecatalog.business.validationrules.fluentvalidator.helpers.ErrorMessageHelper;
import com.furkanisitan.moviecatalog.core.aspects.annotations.FluentValidator;
import com.furkanisitan.moviecatalog.core.exceptions.UniquePropertyException;
import com.furkanisitan.moviecatalog.dataaccess.abstracts.GenreRepository;
import com.furkanisitan.moviecatalog.dataaccess.abstracts.MovieGenreRepository;
import com.furkanisitan.moviecatalog.entities.concretes.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GenreManager implements GenreService {

    private final GenreRepository genreRepository;
    private final MovieGenreRepository movieGenreRepository;

    @Autowired
    public GenreManager(GenreRepository genreRepository, MovieGenreRepository movieGenreRepository) {
        this.genreRepository = genreRepository;
        this.movieGenreRepository = movieGenreRepository;
    }

    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    @Override
    public Optional<Genre> get(int id) {
        return genreRepository.findById(id);
    }

    @FluentValidator(GenreValidator.class)
    @Override
    public int create(Genre genre) {

        // unique name
        if (genreRepository.existsByName(genre.getName()))
            throw new UniquePropertyException("name", ErrorMessageHelper.unique("Name"));

        return genreRepository.save(genre).getId();
    }

    @FluentValidator(GenreValidator.class)
    @Override
    public void update(Genre genre) {

        // unique name
        var existGenre = genreRepository.findByName(genre.getName()).orElse(null);
        if (existGenre != null && existGenre.getId() != genre.getId())
            throw new UniquePropertyException("name", ErrorMessageHelper.unique("Name"));

        genreRepository.save(genre);
    }

    @Transactional
    @Override
    public void delete(Genre genre) {
        movieGenreRepository.deleteAllByIdGenreId(genre.getId());
        genreRepository.delete(genre);
    }
}
