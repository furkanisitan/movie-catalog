package com.furkanisitan.moviecatalog.entities.concretes;

import com.furkanisitan.moviecatalog.entities.ids.MovieGenreId;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "movie_genre")
@Data
public class MovieGenre implements com.furkanisitan.moviecatalog.core.entities.Entity {

    @EmbeddedId
    private MovieGenreId id;

    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @MapsId("genreId")
    @JoinColumn(name = "genre_id")
    private Genre genre;
}
