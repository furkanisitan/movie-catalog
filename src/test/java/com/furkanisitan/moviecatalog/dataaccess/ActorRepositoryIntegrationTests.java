package com.furkanisitan.moviecatalog.dataaccess;

import com.furkanisitan.moviecatalog.dataacces.abstracts.MovieActorRepository;
import com.furkanisitan.moviecatalog.dataacces.abstracts.MovieRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "spring.profiles.active=test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ActorRepositoryIntegrationTests {

    @Autowired
    private MovieActorRepository movieActorRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void test() {

        var movieIdNameResults = movieRepository.getAllByIdSelectIdAndName();


    }
}
