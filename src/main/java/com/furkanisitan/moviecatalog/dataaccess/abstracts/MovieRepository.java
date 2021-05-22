package com.furkanisitan.moviecatalog.dataaccess.abstracts;

import com.furkanisitan.moviecatalog.dataaccess.customrepositories.movie.MovieRepositoryCustom;
import com.furkanisitan.moviecatalog.entities.complexresults.MovieIdNameResult;
import com.furkanisitan.moviecatalog.entities.concretes.Movie;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>, MovieRepositoryCustom {

    @EntityGraph(attributePaths = {"genres"})
    List<Movie> findAll();

    @Query("select new com.furkanisitan.moviecatalog.entities.complexresults.MovieIdNameResult(m.id, m.name) from Movie m")
    List<MovieIdNameResult> getAllSelectIdAndName();
}
