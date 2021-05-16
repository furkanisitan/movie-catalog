package com.furkanisitan.moviecatalog.dataacces.abstracts;

import com.furkanisitan.moviecatalog.entities.concretes.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
}
