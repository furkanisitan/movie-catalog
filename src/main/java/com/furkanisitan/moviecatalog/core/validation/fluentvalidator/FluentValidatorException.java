package com.furkanisitan.moviecatalog.core.validation.fluentvalidator;

import br.com.fluentvalidator.context.ValidationResult;
import br.com.fluentvalidator.exception.ValidationException;

public class FluentValidatorException extends ValidationException {

    public FluentValidatorException(ValidationResult validationResult) {
        super(validationResult);
    }
}
