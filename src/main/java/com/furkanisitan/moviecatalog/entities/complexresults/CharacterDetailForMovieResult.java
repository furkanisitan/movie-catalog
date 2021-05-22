package com.furkanisitan.moviecatalog.entities.complexresults;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterDetailForMovieResult {

    private int actorId;

    private int movieId;

    private String roleName;

    private String actorName;
}
