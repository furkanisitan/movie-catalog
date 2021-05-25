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
                "select m.id, m.name, YEAR(m.release_date) as year, group_concat(g.name separator ', ') as genres from movies m " +
                        "left outer join movie_genre mg on mg.movie_id = m.id " +
                        "left outer join genres g on g.id = mg.genre_id " +
                        "group by m.id, m.name, YEAR(m.release_date)",
                "MovieListResult");

        return query.getResultList();
    }
}
