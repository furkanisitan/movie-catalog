package com.furkanisitan.moviecatalog.dataaccess;

import com.furkanisitan.moviecatalog.dataaccess.abstracts.MovieRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "spring.profiles.active=test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MovieRepositoryIntegrationTests {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void customGetAllMovieListResult_NotThrowException() {

        Assertions.assertDoesNotThrow(() -> {
            movieRepository.customGetAllMovieListResult();
        });

    }
}
