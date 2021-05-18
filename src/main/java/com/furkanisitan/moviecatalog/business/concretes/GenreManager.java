package com.furkanisitan.moviecatalog.business.concretes;

import com.furkanisitan.moviecatalog.business.abstracts.GenreService;
import com.furkanisitan.moviecatalog.dataacces.abstracts.GenreRepository;
import com.furkanisitan.moviecatalog.dataacces.abstracts.MovieGenreRepository;
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

    @Override
    public int save(Genre genre) {
        return genreRepository.save(genre).getId();
    }

    @Override
    public void update(Genre genre) {
        genreRepository.save(genre);
    }

    @Transactional
    @Override
    public void delete(Genre genre) {
        movieGenreRepository.deleteAllByIdGenreId(genre.getId());
        genreRepository.delete(genre);
    }
}
