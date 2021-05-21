package com.furkanisitan.moviecatalog.business.validationrules.fluentvalidator;

import br.com.fluentvalidator.AbstractValidator;
import com.furkanisitan.moviecatalog.business.validationrules.fluentvalidator.helpers.ErrorMessageHelper;
import com.furkanisitan.moviecatalog.entities.concretes.Actor;
import com.furkanisitan.moviecatalog.entities.concretes.MovieActor;
import org.springframework.stereotype.Component;

import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;

@Component
public class ActorValidator extends AbstractValidator<Actor> {

    @Override
    public void rules() {
        ruleFor(Actor::getFullName)
                .must(not(stringEmptyOrNull())).withMessage(ErrorMessageHelper.emptyOrNull("FullName")).withFieldName("fullName").withAttempedValue(Actor::getFullName);
    }
}

