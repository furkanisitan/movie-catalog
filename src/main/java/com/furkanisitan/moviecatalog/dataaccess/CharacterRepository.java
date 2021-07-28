package com.furkanisitan.moviecatalog.dataaccess;

import com.furkanisitan.moviecatalog.entities.concretes.Character;
import com.furkanisitan.moviecatalog.entities.ids.CharacterId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CharacterRepository extends JpaRepository<Character, CharacterId>, JpaSpecificationExecutor<Character> {
}