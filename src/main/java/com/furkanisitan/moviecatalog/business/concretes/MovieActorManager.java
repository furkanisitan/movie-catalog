package com.furkanisitan.moviecatalog.business.concretes;

import com.furkanisitan.moviecatalog.business.abstracts.MovieActorService;
import com.furkanisitan.moviecatalog.business.validationrules.fluentvalidator.MovieActorValidator;
import com.furkanisitan.moviecatalog.business.validationrules.fluentvalidator.helpers.ErrorMessageHelper;
import com.furkanisitan.moviecatalog.core.aspects.annotations.FluentValidator;
import com.furkanisitan.moviecatalog.core.exceptions.UniquePropertyException;
import com.furkanisitan.moviecatalog.dataacces.abstracts.MovieActorRepository;
import com.furkanisitan.moviecatalog.entities.concretes.MovieActor;
import com.furkanisitan.moviecatalog.entities.ids.MovieActorId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieActorManager implements MovieActorService {

    private final MovieActorRepository movieActorRepository;

    @Autowired
    public MovieActorManager(MovieActorRepository movieActorRepository) {
        this.movieActorRepository = movieActorRepository;
    }

    @Override
    public Optional<MovieActor> get(MovieActorId id) {
        return movieActorRepository.findById(id);
    }

    @FluentValidator(MovieActorValidator.class)
    @Override
    public MovieActorId createForMovie(MovieActor movieActor) {
        return create(movieActor, "actorId", "Actor");
    }

    @FluentValidator(MovieActorValidator.class)
    @Override
    public MovieActorId createForActor(MovieActor movieActor) {
        return create(movieActor, "movieId", "Movie");
    }

    @FluentValidator(MovieActorValidator.class)
    @Override
    public void update(MovieActor movieActor) {
        movieActorRepository.save(movieActor);
    }

    @Override
    public void delete(MovieActor movieActor) {
        movieActorRepository.delete(movieActor);
    }

    private MovieActorId create(MovieActor movieActor, String field, String objectName) {

        if (movieActorRepository.existsById(movieActor.getId()))
            throw new UniquePropertyException(field, ErrorMessageHelper.unique(objectName));
        return movieActorRepository.save(movieActor).getId();
    }

}
