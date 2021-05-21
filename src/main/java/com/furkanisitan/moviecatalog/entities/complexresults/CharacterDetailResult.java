package com.furkanisitan.moviecatalog.entities.complexresults;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterDetailResult {

    private int actorId;

    private int movieId;

    private String roleName;

    private String movieName;
}
