package com.furkanisitan.moviecatalog.business.abstracts;

import com.furkanisitan.moviecatalog.entities.complexresults.CharacterDetailForActorResult;
import com.furkanisitan.moviecatalog.entities.concretes.Actor;

import java.util.List;
import java.util.Optional;

public interface ActorService {

    List<Actor> getAll();

    List<CharacterDetailForActorResult> getAllCharacterDetailResults(int id);

    Optional<Actor> get(int id);

    int create(Actor actor);

    void update(Actor actor);

    void delete(Actor actor);
}
