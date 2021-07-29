package com.furkanisitan.moviecatalog.business.concretes;

import com.furkanisitan.moviecatalog.business.abstracts.GenreService;
import com.furkanisitan.moviecatalog.dataaccess.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class GenreManager implements GenreService {

    private final GenreRepository repository;

    @Autowired
    public GenreManager(GenreRepository repository) {
        this.repository = repository;
    }
}
