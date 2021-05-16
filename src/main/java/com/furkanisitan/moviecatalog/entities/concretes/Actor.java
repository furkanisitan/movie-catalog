package com.furkanisitan.moviecatalog.entities.concretes;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "actors")
@Data
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fullName", nullable = false, length = 100)
    private String fullName;

    @OneToMany(mappedBy = "actor")
    private Set<Character> characters = new HashSet<>();
}
