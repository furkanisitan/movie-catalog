package com.furkanisitan.moviecatalog.dataaccess;

import com.furkanisitan.moviecatalog.dataaccess.abstracts.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "spring.profiles.active=test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DemoTest {

    private ActorRepository actorRepository;
    private MovieRepository movieRepository;
    private MovieActorRepository movieActorRepository;
    private MovieGenreRepository movieGenreRepository;

    @Autowired
    public DemoTest(ActorRepository actorRepository, MovieRepository movieRepository, MovieActorRepository movieActorRepository, MovieGenreRepository movieGenreRepository) {
        this.actorRepository = actorRepository;
        this.movieRepository = movieRepository;
        this.movieActorRepository = movieActorRepository;
        this.movieGenreRepository = movieGenreRepository;
    }


    @Test
    public void test() {

        actorRepository.deleteById(1);
    }
}
