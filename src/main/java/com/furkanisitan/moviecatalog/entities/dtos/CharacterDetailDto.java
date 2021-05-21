package com.furkanisitan.moviecatalog.entities.dtos;

import com.furkanisitan.moviecatalog.entities.concretes.MovieActor;
import com.furkanisitan.moviecatalog.entities.ids.MovieActorId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterDetailDto {

    private int actorId;

    private int movieId;

    private String roleName;

    private String movieName;

}
