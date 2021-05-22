package com.furkanisitan.moviecatalog.business.validators;

import com.furkanisitan.moviecatalog.business.validationrules.fluentvalidator.GenreValidator;
import com.furkanisitan.moviecatalog.core.validation.fluentvalidator.FluentValidatorException;
import com.furkanisitan.moviecatalog.core.validation.fluentvalidator.ValidatorTool;
import com.furkanisitan.moviecatalog.entities.concretes.Genre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GenreValidatorUnitTests {

    private GenreValidator genreValidator;

    @BeforeAll
    public void init() {
        genreValidator = new GenreValidator();
    }

    @Test
    public void test_NameEmptyOrNull_ThrowFluentValidatorException() {

        var genre = new Genre();
        genre.setName("");

        Assertions.assertThrows(FluentValidatorException.class, () -> {
            ValidatorTool.validate(genreValidator, genre);
        });
    }

}
