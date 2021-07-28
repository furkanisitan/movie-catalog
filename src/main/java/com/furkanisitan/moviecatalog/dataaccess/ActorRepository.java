package com.furkanisitan.moviecatalog.dataaccess;

import com.furkanisitan.moviecatalog.entities.concretes.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}