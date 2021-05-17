package com.furkanisitan.moviecatalog.entities.concretes;

import com.furkanisitan.moviecatalog.entities.keys.MovieGenreKey;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "movie_genre")
@Data
public class MovieGenre {

    @EmbeddedId
    private MovieGenreKey id;

    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @MapsId("genreId")
    @JoinColumn(name = "genre_id")
    private Genre genre;
}
