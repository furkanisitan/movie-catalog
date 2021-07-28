package com.furkanisitan.moviecatalog.dataaccess;

import com.furkanisitan.moviecatalog.entities.concretes.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}