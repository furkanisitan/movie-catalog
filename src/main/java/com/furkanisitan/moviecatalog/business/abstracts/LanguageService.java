package com.furkanisitan.moviecatalog.business.abstracts;

import com.furkanisitan.moviecatalog.entities.concretes.Language;

import java.util.List;

public interface LanguageService {

    List<Language> getAll();
}
