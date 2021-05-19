package com.furkanisitan.moviecatalog.core.exceptions;

import lombok.Getter;

public class UniquePropertyException extends RuntimeException {

    @Getter
    private String field;

    public UniquePropertyException(String field, String message) {
        super(message);
        this.field = field;
    }
}
