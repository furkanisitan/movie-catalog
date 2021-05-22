package com.furkanisitan.moviecatalog.dataaccess.abstracts;

import com.furkanisitan.moviecatalog.entities.complexresults.CharacterDetailResult;
import com.furkanisitan.moviecatalog.entities.concretes.MovieActor;
import com.furkanisitan.moviecatalog.entities.ids.MovieActorId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MovieActorRepository extends JpaRepository<MovieActor, MovieActorId> {

    @Query("select new com.furkanisitan.moviecatalog.entities.complexresults.CharacterDetailResult(ma.id.actorId, ma.id.movieId, ma.roleName, m.name) from MovieActor ma join Movie m on m.id = ma.id.movieId where ma.id.actorId = :actorId")
    List<CharacterDetailResult> getAllByIdActorId(@Param("actorId") int actorId);

    @Transactional
    void deleteAllByIdActorId(int actorId);
}