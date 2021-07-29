package com.furkanisitan.moviecatalog.business.concretes;

import com.furkanisitan.moviecatalog.business.abstracts.LanguageService;
import com.furkanisitan.moviecatalog.dataaccess.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class LanguageManager implements LanguageService {

    private final LanguageRepository repository;

    @Autowired
    public LanguageManager(LanguageRepository repository) {
        this.repository = repository;
    }
}
