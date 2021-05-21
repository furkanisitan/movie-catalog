package com.furkanisitan.moviecatalog.webmvc.dtos.actor;

import lombok.Data;

@Data
public class CharacterDto {

    private int actorId;

    private int movieId;

    private String roleName;

}
