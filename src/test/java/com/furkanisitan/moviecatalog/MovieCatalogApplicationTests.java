package com.furkanisitan.moviecatalog;

import com.furkanisitan.moviecatalog.entities.concretes.Actor;
import com.furkanisitan.moviecatalog.entities.concretes.Character;
import com.furkanisitan.moviecatalog.entities.concretes.Movie;
import com.furkanisitan.moviecatalog.entities.embeddeds.Born;
import com.furkanisitan.moviecatalog.entities.ids.CharacterId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDate;

@SpringBootTest
class MovieCatalogApplicationTests {

    @Autowired
    private EntityManager entityManager;


    @Test
    @Transactional
    @Rollback(value = false)
    void contextLoads() {

//        var movie = new Movie();
//        movie.setName("The Lord of the Rings: The Fellowship of the Ring");
//        movie.setDescription("A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.");
//        movie.setDirector("Peter Jackson");
//        movie.setReleaseDate(LocalDate.of(2001, 12, 10));
//
//        var actor = new Actor();
//        actor.setFirstName("Ian");
//        actor.setLastName("McKellen");
//        var born = new Born();
//        born.setDate(LocalDate.of(1939, 5, 25));
//        born.setPlace("Burnley, Lancashire, England, UK");
//        actor.setBorn(born);
//
//        entityManager.persist(movie);
//        entityManager.persist(actor);
//
//
//        var character = new Character();
//        var characterId = new CharacterId();
//        characterId.setMovie(movie);
//        characterId.setActor(actor);
//        character.setId(characterId);
//        character.setName("Gandalf");
//
//        entityManager.persist(character);



//        var recordedMovie = entityManager.getReference(Movie.class, 1L);
//        var recordedActor = entityManager.getReference(Actor.class, 1L);
//
//        var recordedCharacter = entityManager.find(Character.class, new CharacterId(recordedMovie, recordedActor));

    }

}
