package com.furkanisitan.moviecatalog.dataacces.abstracts;

import com.furkanisitan.moviecatalog.entities.concretes.MovieActor;
import com.furkanisitan.moviecatalog.entities.keys.MovieActorKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<MovieActor, MovieActorKey> {

    List<MovieActor> findAllByIdActorId(int actorId);

    @Transactional
    void deleteAllByIdActorId(int actorId);
}
