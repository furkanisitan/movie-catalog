package com.furkanisitan.moviecatalog.business.abstracts;

import com.furkanisitan.moviecatalog.entities.concretes.Actor;
import com.furkanisitan.moviecatalog.entities.concretes.Genre;

import java.util.List;
import java.util.Optional;

public interface ActorService {

    List<Actor> getAll();

    Optional<Actor> get(int id);

    int save(Actor actor);

    void update(Actor actor);

    void delete(Actor actor);
}
