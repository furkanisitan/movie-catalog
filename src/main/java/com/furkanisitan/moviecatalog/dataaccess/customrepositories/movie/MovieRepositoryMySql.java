package com.furkanisitan.moviecatalog.dataaccess.customrepositories.movie;

import com.furkanisitan.moviecatalog.entities.complexresults.MovieListResult;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

class MovieRepositoryMySql implements MovieRepositoryDb {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<MovieListResult> customGetAllMovieListResult() {

        var query = entityManager.createNativeQuery(
                "select m.id, m.name, YEAR(m.release_date) as year, group_concat(g.name separator ', ') as genres from movie_genre " +
                        "join movies m on m.id = movie_genre.movie_id " +
                        "join genres g on g.id = movie_genre.genre_id " +
                        "group by m.id, m.name, YEAR(m.release_date)",
                "MovieListResult");

        return query.getResultList();

    }
}
