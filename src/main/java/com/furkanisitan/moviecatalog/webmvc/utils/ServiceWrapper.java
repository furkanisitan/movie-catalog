package com.furkanisitan.moviecatalog.webmvc.utils;

import com.furkanisitan.moviecatalog.core.exceptions.UniquePropertyException;
import com.furkanisitan.moviecatalog.core.validation.fluentvalidator.FluentValidatorException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * Wrapper for service methods. Handles exceptions.
 *
 * @param <T> Return type of the wrapped method.
 */
public abstract class ServiceWrapper<T> {

    private final boolean success;

    protected ServiceWrapper(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public boolean isFailure() {
        return !success;
    }

    public abstract T get();

    private static <V> ServiceWrapper.Success<V> success() {
        return new Success<>(null);
    }

    private static <V> ServiceWrapper.Success<V> success(V value) {
        return new Success<>(value);
    }

    private static <T> ServiceWrapper<T> failure(Throwable t) {
        Objects.requireNonNull(t);
        return new Failure<>(t);
    }

    public static <T> ServiceWrapper<T> of(Supplier<T> fn, BindingResult result, String objectName) {
        Objects.requireNonNull(fn);
        try {
            return ServiceWrapper.success(fn.get());
        } catch (FluentValidatorException e) {
            handleFluentValidatorException(e, result, objectName);
            return ServiceWrapper.failure(e);
        } catch (UniquePropertyException e) {
            handleUniquePropertyException(e, result, objectName);
            return ServiceWrapper.failure(e);
        }
    }

    public static ServiceWrapper<Objects> of(Runnable fn, BindingResult result, String objectName) {
        Objects.requireNonNull(fn);
        try {
            fn.run();
            return ServiceWrapper.success();
        } catch (FluentValidatorException e) {
            handleFluentValidatorException(e, result, objectName);
            return ServiceWrapper.failure(e);
        } catch (UniquePropertyException e) {
            handleUniquePropertyException(e, result, objectName);
            return ServiceWrapper.failure(e);
        }
    }

    private static void handleFluentValidatorException(FluentValidatorException e, BindingResult result, String objectName) {
        for (var error : e.getValidationResult().getErrors()) {
            result.addError(new FieldError(objectName, error.getField(), error.getMessage()));
        }
    }

    private static void handleUniquePropertyException(UniquePropertyException e, BindingResult result, String objectName) {
        result.addError(new FieldError(objectName, e.getField(), e.getMessage()));
    }

    private static class Success<T> extends ServiceWrapper<T> {

        private final T value;

        protected Success(T value) {
            super(true);
            this.value = value;
        }

        @Override
        public T get() {
            return this.value;
        }
    }

    private static class Failure<T> extends ServiceWrapper<T> {

        private final RuntimeException exception;

        protected Failure(Throwable t) {
            super(false);
            this.exception = new RuntimeException(t);
        }

        @Override
        public T get() {
            throw this.exception;
        }
    }

}
