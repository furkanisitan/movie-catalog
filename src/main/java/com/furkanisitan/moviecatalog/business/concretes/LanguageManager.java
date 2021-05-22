package com.furkanisitan.moviecatalog.business.concretes;

import com.furkanisitan.moviecatalog.business.abstracts.LanguageService;
import com.furkanisitan.moviecatalog.dataaccess.abstracts.LanguageRepository;
import com.furkanisitan.moviecatalog.entities.concretes.Language;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    private final LanguageRepository languageRepository;

    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<Language> getAll() {
        return languageRepository.findAll();
    }
}
