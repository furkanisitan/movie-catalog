package com.furkanisitan.moviecatalog.core.aspects.helpers;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericHelper {

    /**
     * @param clazz The class that implements a generic interface.
     * @return the type of the first of the generic interfaces implemented by the 'clazz'.
     */
    public static Type getGenericInterfaceType(Class<?> clazz) {
        return getGenericInterfaceType(clazz, 0);
    }

    /**
     * @param clazz The class that implements a generic interface.
     * @param index The generic interface's index. (array => generic interfaces implemented by 'clazz')
     * @return the type of one of the generic interfaces implemented by 'clazz', according to 'index'.
     */
    public static Type getGenericInterfaceType(Class<?> clazz, int index) {
        var interfaces = clazz.getGenericInterfaces();
        if (interfaces.length == 0) return null;
        return interfaces[index];
    }

    /**
     * @param type The type of the generic class or interface.
     * @return the class of first of the actual type arguments of 'type'.
     */
    public static Class<?> getActualTypeArgumentClass(Type type) {
        return getActualTypeArgumentClass(type, 0);
    }

    /**
     * @param type  The type of the generic class or interface.
     * @param index The actual type argument's index. (array => Actual type arguments of the 'type'.)
     * @return the class of one of the actual type arguments of 'type', according to 'index'.
     */
    public static Class<?> getActualTypeArgumentClass(Type type, int index) {
        if (type == null) return null;
        var args = ((ParameterizedType) type).getActualTypeArguments();
        return args.length == 0 ? null : (Class<?>) args[index];
    }

}
