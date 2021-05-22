package com.furkanisitan.moviecatalog.dataaccess.customrepositories.movie;

import com.furkanisitan.moviecatalog.entities.complexresults.MovieListResult;

import java.util.List;

interface MovieRepositoryDb {

    List<MovieListResult> customGetAllMovieListResult();
}
