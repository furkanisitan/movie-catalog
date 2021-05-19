package com.furkanisitan.moviecatalog.business.validationrules.fluentvalidator;

import br.com.fluentvalidator.AbstractValidator;
import com.furkanisitan.moviecatalog.business.validationrules.fluentvalidator.helpers.ErrorMessageHelper;
import com.furkanisitan.moviecatalog.entities.concretes.Genre;
import org.springframework.stereotype.Component;

import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;


@Component
public class GenreValidator extends AbstractValidator<Genre> {

    @Override
    public void rules() {
        ruleFor(Genre::getName)
                .must(not(stringEmptyOrNull())).withMessage(ErrorMessageHelper.emptyOrNull("Name")).withFieldName("name").withAttempedValue(Genre::getName);
    }
}
