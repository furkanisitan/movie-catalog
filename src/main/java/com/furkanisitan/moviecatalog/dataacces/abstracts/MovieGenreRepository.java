package com.furkanisitan.moviecatalog.dataacces.abstracts;

import com.furkanisitan.moviecatalog.entities.concretes.MovieGenre;
import com.furkanisitan.moviecatalog.entities.keys.MovieGenreKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieGenreRepository extends JpaRepository<MovieGenre, MovieGenreKey> {

    List<MovieGenre> findAllByIdGenreId(int genreId);

    @Transactional
    void deleteAllByIdGenreId(int genreId);
}
