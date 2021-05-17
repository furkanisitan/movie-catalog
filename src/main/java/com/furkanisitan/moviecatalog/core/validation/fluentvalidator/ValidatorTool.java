package com.furkanisitan.moviecatalog.core.validation.fluentvalidator;

import br.com.fluentvalidator.AbstractValidator;
import com.furkanisitan.moviecatalog.core.entities.Entity;

public class ValidatorTool {

    /**
     * Validates the entity.
     *
     * @param validator The validator to validate the entity.
     * @param entity    The entity to validate.
     * @param <T>       The type of entity.
     * @throws FluentValidatorException Throw when validation is failed.
     */
    public static <T extends Entity> void validate(AbstractValidator<T> validator, T entity) {

        var result = validator.validate(entity);

        if (!result.isValid())
            throw new FluentValidatorException(result);
    }
}
