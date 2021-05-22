package com.furkanisitan.moviecatalog.entities.ids;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class MovieActorId implements Serializable {

    @Column(name = "movie_id")
    private int movieId;

    @Column(name = "actor_id")
    private int actorId;
}

