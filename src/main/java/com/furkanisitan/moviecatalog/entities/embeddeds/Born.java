package com.furkanisitan.moviecatalog.entities.embeddeds;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Born {

    private String place;
    private LocalDate date;
}
