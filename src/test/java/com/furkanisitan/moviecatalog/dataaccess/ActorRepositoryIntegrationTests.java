package com.furkanisitan.moviecatalog.dataaccess;

import com.furkanisitan.moviecatalog.dataacces.abstracts.MovieActorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "spring.profiles.active=test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ActorRepositoryIntegrationTests {

    @Autowired
    private MovieActorRepository movieActorRepository;

    @Test
    public void test() {

        var movieActorList = movieActorRepository.findAllByIdActorId(2);

//
//        var actor = actorRepository.findWithMovies(2).get();
//        var movieActors = actor.getMovieActors();
//        var movies = actor.getMovies();


    }
}
