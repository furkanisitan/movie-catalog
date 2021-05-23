package com.furkanisitan.moviecatalog.business.validationrules.fluentvalidator;

import br.com.fluentvalidator.AbstractValidator;
import com.furkanisitan.moviecatalog.business.validationrules.fluentvalidator.helpers.ErrorMessageHelper;
import com.furkanisitan.moviecatalog.entities.concretes.Movie;
import org.springframework.stereotype.Component;

import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;

@Component
public class MovieValidator extends AbstractValidator<Movie> {

    @Override
    public void rules() {
        ruleFor(Movie::getName)
                .must(not(stringEmptyOrNull())).withMessage(ErrorMessageHelper.emptyOrNull("Name")).withFieldName("name").withAttempedValue(Movie::getName);

        ruleFor(Movie::getReleaseDate)
                .must(not(nullValue())).withMessage(ErrorMessageHelper.emptyOrNull("ReleaseDate")).withFieldName("releaseDate").withAttempedValue(Movie::getReleaseDate);
    }
}
