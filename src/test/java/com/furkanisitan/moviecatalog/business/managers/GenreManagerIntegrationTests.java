package com.furkanisitan.moviecatalog.business.managers;

import com.furkanisitan.moviecatalog.business.concretes.GenreManager;
import com.furkanisitan.moviecatalog.dataacces.abstracts.MovieGenreRepository;
import com.furkanisitan.moviecatalog.dataacces.abstracts.MovieRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(properties = "spring.profiles.active=test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GenreManagerIntegrationTests {

    private GenreManager genreManager;
    private MovieRepository movieRepository;
    private MovieGenreRepository movieGenreRepository;

    @Autowired
    public GenreManagerIntegrationTests(GenreManager genreManager, MovieRepository movieRepository, MovieGenreRepository movieGenreRepository) {
        this.genreManager = genreManager;
        this.movieRepository = movieRepository;
        this.movieGenreRepository = movieGenreRepository;
    }

    /**
     * Genre kaydı silindiğinde many-to-many ilişkileri tutan MovieGenre kayıtları da silinmeli.
     * Ancak ilişkili olduğu Movie kayıtları silinmemeli.
     */
    @Test
    public void delete_ByDeletedGenreId_NotRemoveAssociatedMovie() {

        var deletedGenreId = 1;
        var movieGenre = movieGenreRepository.getByIdGenreId(deletedGenreId).orElseThrow();
        var movieId = movieGenre.getId().getMovieId();

        genreManager.delete(deletedGenreId);

        var movie = movieRepository.findById(movieId);
        var deletedMovieGenre = movieGenreRepository.getByIdGenreId(deletedGenreId);

        assertTrue(movie.isPresent());
        assertTrue(deletedMovieGenre.isEmpty());
    }
}
