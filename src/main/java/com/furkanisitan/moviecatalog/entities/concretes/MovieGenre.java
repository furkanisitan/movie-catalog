package com.furkanisitan.moviecatalog.entities.concretes;

import com.furkanisitan.moviecatalog.entities.ids.MovieGenreId;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movie_genre")
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
