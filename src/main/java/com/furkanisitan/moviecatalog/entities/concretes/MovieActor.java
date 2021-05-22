package com.furkanisitan.moviecatalog.entities.concretes;

import com.furkanisitan.moviecatalog.entities.ids.MovieActorId;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movie_actor")
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

