package com.furkanisitan.moviecatalog.entities.ids;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class CharacterId implements Serializable {

    @Column(name = "movie_id", nullable = false)
    private Long movieId;

    @Column(name = "actor_id", nullable = false)
    private Long actorId;

}