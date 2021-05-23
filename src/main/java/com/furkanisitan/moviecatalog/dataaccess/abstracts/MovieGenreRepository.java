package com.furkanisitan.moviecatalog.dataaccess.abstracts;

import com.furkanisitan.moviecatalog.entities.concretes.MovieGenre;
import com.furkanisitan.moviecatalog.entities.ids.MovieGenreId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MovieGenreRepository extends JpaRepository<MovieGenre, MovieGenreId> {

    List<MovieGenre> findAllByIdGenreId(int genreId);

    @Transactional
    void deleteAllByIdGenreId(int genreId);

    @Transactional
    void deleteAllByIdMovieId(int movieId);
}
