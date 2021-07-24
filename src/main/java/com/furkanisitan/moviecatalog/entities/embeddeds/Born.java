package com.furkanisitan.moviecatalog.entities.embeddeds;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;

@Getter
@Setter
@Embeddable
public class Born {

    @Column(name = "place_of_birth", nullable = false, length = 100)
    private String place;

    @Column(name = "date_of_birth", nullable = false, columnDefinition = "DATE")
    private LocalDate date;
}
