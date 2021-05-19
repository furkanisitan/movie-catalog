package com.furkanisitan.moviecatalog.core.aspects;

import br.com.fluentvalidator.AbstractValidator;
import com.furkanisitan.moviecatalog.core.aspects.annotations.FluentValidator;
import com.furkanisitan.moviecatalog.core.aspects.helpers.GenericHelper;
import com.furkanisitan.moviecatalog.core.entities.Entity;
import com.furkanisitan.moviecatalog.core.validation.fluentvalidator.ValidatorTool;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

@Aspect
@Component
public class FluentValidatorAspect {

    private final BeanFactory beanFactory;

    @Autowired
    public FluentValidatorAspect(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Before("@annotation(fluentValidator)")
    public void validate(JoinPoint joinPoint, FluentValidator fluentValidator) throws Throwable {

        // Get the entity class from the generic base class of the validator class.
        var entityClass = GenericHelper.getActualTypeArgumentClass(fluentValidator.value().getGenericSuperclass());

        var entities = Arrays.stream(joinPoint.getArgs()).filter(x -> x.getClass() == entityClass).toArray();

        // Get object of the validator class.
        var validator = beanFactory.getBean(fluentValidator.value());

        // Get fluentValidate method at runtime.
        var validateMethod = ValidatorTool.class.getMethod("validate", AbstractValidator.class, Entity.class);

        // Throws an 'InvocationTargetException' when there is an error in methods that are executed by reflection.
        // It must be wrapped with try-catch for get the real exception.
        try {
            for (var entity : entities)
                validateMethod.invoke(null, validator, entity);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        }
    }
}
