package com.furkanisitan.moviecatalog.entities.concretes;

import com.furkanisitan.moviecatalog.entities.keys.CharacterKey;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "characters")
@Data
public class Character {

    @EmbeddedId
    private CharacterKey id;

    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @MapsId("actorId")
    @JoinColumn(name = "actor_id")
    private Actor actor;

    @Column(name = "role_name", nullable = false, length = 100)
    private String roleName;
}