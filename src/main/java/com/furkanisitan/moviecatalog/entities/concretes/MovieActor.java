package com.furkanisitan.moviecatalog.entities.concretes;

import com.furkanisitan.moviecatalog.entities.ids.MovieActorId;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "movie_actor")
@Data
public class MovieActor implements com.furkanisitan.moviecatalog.core.entities.Entity {

    @EmbeddedId
    private MovieActorId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("movieId")
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("actorId")
    @JoinColumn(name = "actor_id")
    private Actor actor;

    @Column(name = "role_name", nullable = false, length = 100)
    private String roleName;
}

