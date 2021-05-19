package com.furkanisitan.moviecatalog.webmvc.dtos.genres;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class GenreDto {

    private int id;

    @NotBlank
    private String name;
}
