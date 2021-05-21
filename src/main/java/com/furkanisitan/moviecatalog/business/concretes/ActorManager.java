package com.furkanisitan.moviecatalog.business.concretes;

import com.furkanisitan.moviecatalog.business.abstracts.ActorService;
import com.furkanisitan.moviecatalog.business.validationrules.fluentvalidator.ActorValidator;
import com.furkanisitan.moviecatalog.core.aspects.annotations.FluentValidator;
import com.furkanisitan.moviecatalog.dataacces.abstracts.ActorRepository;
import com.furkanisitan.moviecatalog.dataacces.abstracts.MovieActorRepository;
import com.furkanisitan.moviecatalog.entities.concretes.Actor;
import com.furkanisitan.moviecatalog.entities.dtos.CharacterDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ActorManager implements ActorService {

    private final ActorRepository actorRepository;
    private final MovieActorRepository movieActorRepository;

    @Autowired
    public ActorManager(ActorRepository actorRepository, MovieActorRepository movieActorRepository) {
        this.actorRepository = actorRepository;
        this.movieActorRepository = movieActorRepository;
    }

    @Override
    public List<Actor> getAll() {
        return actorRepository.findAll();
    }

    @Override
    public List<CharacterDetailDto> getAllCharacters(int id) {
        return movieActorRepository.findAllByIdActorId(id);
    }

    @Override
    public Optional<Actor> get(int id) {
        return actorRepository.findById(id);
    }

    @FluentValidator(ActorValidator.class)
    @Override
    public int create(Actor actor) {
        return actorRepository.save(actor).getId();
    }

    @FluentValidator(ActorValidator.class)
    @Override
    public void update(Actor actor) {
        actorRepository.save(actor);
    }

    @Transactional
    @Override
    public void delete(Actor actor) {
        movieActorRepository.deleteAllByIdActorId(actor.getId());
        actorRepository.delete(actor);
    }
}
