package com.furkanisitan.moviecatalog.entities.concretes;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "actors")
@Data
public class Actor implements com.furkanisitan.moviecatalog.core.entities.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fullName", nullable = false, length = 100)
    private String fullName;

//    @OneToMany(mappedBy = "actor")
//    private Set<MovieActor> movieActors = new HashSet<>();

    @ManyToMany(mappedBy = "actors")
    List<Movie> movies = new ArrayList<Movie>();
}
