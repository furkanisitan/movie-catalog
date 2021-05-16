package com.furkanisitan.moviecatalog.dataacces.abstracts;

import com.furkanisitan.moviecatalog.entities.concretes.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
}

