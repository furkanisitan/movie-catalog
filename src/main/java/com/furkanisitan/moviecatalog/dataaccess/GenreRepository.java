package com.furkanisitan.moviecatalog.dataaccess;

import com.furkanisitan.moviecatalog.entities.concretes.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}