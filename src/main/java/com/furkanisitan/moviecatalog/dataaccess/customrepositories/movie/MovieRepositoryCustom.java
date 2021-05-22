package com.furkanisitan.moviecatalog.dataaccess.customrepositories.movie;

import com.furkanisitan.moviecatalog.entities.complexresults.MovieListResult;

import java.util.List;

public interface MovieRepositoryCustom {

    List<MovieListResult> customGetAllMovieListResult();
}
