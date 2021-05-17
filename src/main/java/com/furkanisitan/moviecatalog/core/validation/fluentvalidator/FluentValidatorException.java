package com.furkanisitan.moviecatalog.core.validation.fluentvalidator;

import br.com.fluentvalidator.context.ValidationResult;
import br.com.fluentvalidator.exception.ValidationException;

public class FluentValidatorException extends ValidationException {

    protected FluentValidatorException(ValidationResult validationResult) {
        super(validationResult);
    }
}
