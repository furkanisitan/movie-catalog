package com.furkanisitan.moviecatalog.business.abstracts;

import com.furkanisitan.moviecatalog.entities.concretes.Actor;
import com.furkanisitan.moviecatalog.entities.dtos.CharacterDetailDto;

import java.util.List;
import java.util.Optional;

public interface ActorService {

    List<Actor> getAll();

    List<CharacterDetailDto> getAllCharacters(int id);

    Optional<Actor> get(int id);

    int create(Actor actor);

    void update(Actor actor);

    void delete(Actor actor);
}
