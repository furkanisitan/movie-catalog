package com.furkanisitan.moviecatalog.business.concretes;

import com.furkanisitan.moviecatalog.business.abstracts.ActorService;
import com.furkanisitan.moviecatalog.dataacces.abstracts.ActorRepository;
import com.furkanisitan.moviecatalog.dataacces.abstracts.CharacterRepository;
import com.furkanisitan.moviecatalog.entities.concretes.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ActorManager implements ActorService {

    private final ActorRepository actorRepository;
    private final CharacterRepository characterRepository;

    @Autowired
    public ActorManager(ActorRepository actorRepository, CharacterRepository characterRepository) {
        this.actorRepository = actorRepository;
        this.characterRepository = characterRepository;
    }

    @Override
    public List<Actor> getAll() {
        return actorRepository.findAll();
    }

    @Override
    public Optional<Actor> get(int id) {
        return actorRepository.findById(id);
    }

    @Override
    public int save(Actor actor) {
        return actorRepository.save(actor).getId();
    }

    @Override
    public void update(Actor actor) {
        actorRepository.save(actor);
    }

    @Transactional
    @Override
    public void delete(Actor actor) {
        characterRepository.deleteAllByIdActorId(actor.getId());
        actorRepository.delete(actor);
    }
}
