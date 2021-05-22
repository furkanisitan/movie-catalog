package com.furkanisitan.moviecatalog.entities.ids;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class MovieGenreId implements Serializable {

    @Column(name = "movie_id")
    private int movieId;

    @Column(name = "genre_id")
    private int genreId;
}
