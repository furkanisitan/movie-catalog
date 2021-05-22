package com.furkanisitan.moviecatalog.business.managers;

import com.furkanisitan.moviecatalog.business.concretes.GenreManager;
import com.furkanisitan.moviecatalog.dataaccess.abstracts.GenreRepository;
import com.furkanisitan.moviecatalog.entities.concretes.Genre;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GenreManagerUnitTests {

    @InjectMocks
    GenreManager genreManager;

    @Mock
    GenreRepository genreRepository;

    @BeforeAll
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAll_GenreSizeGraterThen0_ReturnListNotEmpty() {

        var genre1 = new Genre();
        genre1.setId(1);
        genre1.setName("Drama");

        var genre2 = new Genre();
        genre2.setId(2);
        genre2.setName("Korku");

        List<Genre> list = new ArrayList<>();
        list.add(genre1);
        list.add(genre2);

        when(genreRepository.findAll()).thenReturn(list);

        var genreList = genreManager.getAll();

        assertFalse(genreList.isEmpty());

        // verify findAll() is called 1 times on genreRepository
        Mockito.verify(genreRepository, Mockito.times(1)).findAll();
    }
}
