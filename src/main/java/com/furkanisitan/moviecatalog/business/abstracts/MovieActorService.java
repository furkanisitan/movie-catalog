package com.furkanisitan.moviecatalog.business.abstracts;

import com.furkanisitan.moviecatalog.entities.concretes.MovieActor;
import com.furkanisitan.moviecatalog.entities.ids.MovieActorId;

import java.util.Optional;

public interface MovieActorService {

    Optional<MovieActor> get(MovieActorId id);

    MovieActorId createForMovie(MovieActor movieActor);

    MovieActorId createForActor(MovieActor movieActor);

    void update(MovieActor movieActor);

    void delete(MovieActor movieActor);

}
