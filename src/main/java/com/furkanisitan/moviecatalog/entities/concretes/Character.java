package com.furkanisitan.moviecatalog.entities.concretes;

import com.furkanisitan.moviecatalog.entities.ids.CharacterId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "characters")
@Entity
@Getter
@Setter
public class Character {

    @EmbeddedId
    private CharacterId id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;
}