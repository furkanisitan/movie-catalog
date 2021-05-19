package com.furkanisitan.moviecatalog.business.validationrules.fluentvalidator.helpers;

import java.util.List;

public class ErrorMessageHelper {

    public static String emptyOrNull(String field) {
        return String.format("%s must be not null or empty.", field);
    }

    public static String nullOrZero(String field) {
        return String.format("%s must be not null or 0.", field);
    }

    public static String notExist(String field) {
        return String.format("%s does not exist.", field);
    }

    public static String sizeLessThanOrEqual(String field, int size) {
        return String.format("%s length must be less than or equal %d.", field, size);
    }

    public static String acceptedValue(String field, List<String> acceptedValues) {
        return String.format("%s not one of the values accepted: %s", field, acceptedValues);
    }

    public static String unique(String field) {
        return String.format("%s must be unique.", field);
    }

}
