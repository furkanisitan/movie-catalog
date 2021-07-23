package com.furkanisitan.moviecatalog.entities.concretes;

import com.furkanisitan.moviecatalog.entities.embeddeds.Born;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Actor {

    private Long id;
    private String firstName;
    private String lastName;
    private Born born;
}
