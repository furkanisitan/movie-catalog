package com.furkanisitan.moviecatalog.entities.concretes;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Movie {

    private Long id;
    private String name;
    private String description;
    private String director;
    private LocalDate releaseDate;
}
