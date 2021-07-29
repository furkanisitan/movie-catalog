package com.furkanisitan.moviecatalog.business.concretes;

import com.furkanisitan.moviecatalog.business.abstracts.MovieService;
import com.furkanisitan.moviecatalog.dataaccess.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class MovieManager implements MovieService {

    private final MovieRepository repository;

    @Autowired
    public MovieManager(MovieRepository repository) {
        this.repository = repository;
    }
}
