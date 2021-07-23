package com.furkanisitan.moviecatalog.entities.concretes.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
}
