package com.furkanisitan.moviecatalog.dataaccess.abstracts;

import com.furkanisitan.moviecatalog.entities.complexresults.CharacterDetailForActorResult;
import com.furkanisitan.moviecatalog.entities.complexresults.CharacterDetailForMovieResult;
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

    @Query("select new com.furkanisitan.moviecatalog.entities.complexresults.CharacterDetailForActorResult(ma.id.actorId, ma.id.movieId, ma.roleName, m.name) from MovieActor ma join Movie m on m.id = ma.id.movieId where ma.id.actorId = :actorId")
    List<CharacterDetailForActorResult> getAllCharacterDetailForActorResult(@Param("actorId") int actorId);

    @Query("select new com.furkanisitan.moviecatalog.entities.complexresults.CharacterDetailForMovieResult(ma.id.actorId, ma.id.movieId, ma.roleName, a.fullName) from MovieActor ma join Actor a on a.id = ma.id.actorId where ma.id.movieId = :movieId")
    List<CharacterDetailForMovieResult> getAllCharacterDetailForMovieResult(@Param("movieId") int movieId);


    @Transactional
    void deleteAllByIdActorId(int actorId);
}
