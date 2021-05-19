package com.furkanisitan.moviecatalog.core.aspects.annotations;

import br.com.fluentvalidator.AbstractValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FluentValidator {

    /**
     * Returns the validator class to be used for validation.
     *
     * @return the validator class to be used for validation.
     */
    Class<? extends AbstractValidator<?>> value();
}
