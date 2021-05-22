package com.furkanisitan.moviecatalog.dataaccess;

import com.furkanisitan.moviecatalog.dataaccess.abstracts.GenreRepository;
import com.furkanisitan.moviecatalog.dataaccess.abstracts.LanguageRepository;
import com.furkanisitan.moviecatalog.dataaccess.abstracts.MovieRepository;
import com.furkanisitan.moviecatalog.entities.concretes.Genre;
import com.furkanisitan.moviecatalog.entities.concretes.Language;
import com.furkanisitan.moviecatalog.entities.concretes.Movie;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest(properties = "spring.profiles.active=test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DemoTest {

    private MovieRepository movieRepository;
    private LanguageRepository languageRepository;
    private GenreRepository genreRepository;

    @Autowired
    public DemoTest(MovieRepository movieRepository, LanguageRepository languageRepository, GenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.languageRepository = languageRepository;
        this.genreRepository = genreRepository;
    }


    @Test
    public void test() {

        var genres = genreRepository.findAll();
        var languages = languageRepository.findAll();

        var addedGenres = new HashSet<Genre>();
        addedGenres.add(genres.get(0));
        addedGenres.add(genres.get(1));

        var addedLanguages = new HashSet<Language>();
        addedLanguages.add(languages.get(0));
        addedLanguages.add(languages.get(1));


        var movie = new Movie();
        movie.setName("test");
        movie.setReleaseDate(new Date());
        movie.setMedia("aa");
        movie.setDescription("aa");
        movie.setGenres(addedGenres);
        movie.setLanguages(addedLanguages);

        movieRepository.save(movie);

    }
}
