package com.furkanisitan.moviecatalog.entities.concretes;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "actors")
public class Actor implements com.furkanisitan.moviecatalog.core.entities.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fullName", nullable = false, length = 100)
    private String fullName;

    @ManyToMany(mappedBy = "actors")
    List<Movie> movies = new ArrayList<>();
}
