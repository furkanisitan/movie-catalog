package com.furkanisitan.moviecatalog.entities.keys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class MovieGenreKey implements Serializable {

    @Column(name = "movie_id")
    private int movieId;

    @Column(name = "genre_id")
    private int genreId;
}
