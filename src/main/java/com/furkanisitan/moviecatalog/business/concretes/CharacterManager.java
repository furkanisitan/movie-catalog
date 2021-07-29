package com.furkanisitan.moviecatalog.business.concretes;

import com.furkanisitan.moviecatalog.business.abstracts.CharacterService;
import com.furkanisitan.moviecatalog.dataaccess.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class CharacterManager implements CharacterService {

    private final CharacterRepository repository;

    @Autowired
    public CharacterManager(CharacterRepository repository) {
        this.repository = repository;
    }
}
