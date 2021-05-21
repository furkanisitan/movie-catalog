package com.furkanisitan.moviecatalog.business.validationrules.fluentvalidator;

import br.com.fluentvalidator.AbstractValidator;
import com.furkanisitan.moviecatalog.business.validationrules.fluentvalidator.helpers.ErrorMessageHelper;
import com.furkanisitan.moviecatalog.entities.concretes.MovieActor;
import org.springframework.stereotype.Component;

import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;

@Component
public class MovieActorValidator extends AbstractValidator<MovieActor> {

    @Override
    public void rules() {
        ruleFor(MovieActor::getRoleName)
                .must(not(stringEmptyOrNull())).withMessage(ErrorMessageHelper.emptyOrNull("RoleName")).withFieldName("roleName").withAttempedValue(MovieActor::getRoleName);
    }
}
