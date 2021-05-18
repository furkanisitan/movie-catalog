package com.furkanisitan.moviecatalog.business.abstracts;

import com.furkanisitan.moviecatalog.entities.concretes.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {

    List<Genre> getAll();

    Optional<Genre> get(int id);

    int save(Genre genre);

    void update(Genre genre);

    void delete(Genre genre);
}
