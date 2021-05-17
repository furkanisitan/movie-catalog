package com.furkanisitan.moviecatalog.business.managers;

import com.furkanisitan.moviecatalog.business.concretes.GenreManager;
import com.furkanisitan.moviecatalog.dataacces.abstracts.GenreRepository;
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
public class GenreManagerTests {

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

        List<Genre> list = new ArrayList<>();
        list.add(Genre.builder().id(1).name("Drama").build());
        list.add(Genre.builder().id(2).name("Korku").build());

        when(genreRepository.findAll()).thenReturn(list);

        var genreList = genreManager.getAll();

        assertFalse(genreList.isEmpty());

        // verify findAll() is called 1 times on genreRepository
        Mockito.verify(genreRepository, Mockito.times(1)).findAll();
    }
}
