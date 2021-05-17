package com.furkanisitan.moviecatalog.entities.concretes;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "languages")
@Data
public class Language implements com.furkanisitan.moviecatalog.core.entities.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false, length = 100, unique = true)
    private String name;

    @Column(name = "code", nullable = false, length = 10, unique = true)
    private String code;

    @ManyToMany(mappedBy = "languages")
    private Set<Movie> movies = new HashSet<>();
}
