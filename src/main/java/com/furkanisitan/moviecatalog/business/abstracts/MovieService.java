package com.furkanisitan.moviecatalog.business.abstracts;

import com.furkanisitan.moviecatalog.entities.concretes.Movie;

import java.util.List;


public interface MovieService {

    List<Movie> getAll();
}
