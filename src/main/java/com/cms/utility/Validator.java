package com.cms.utility;

public class Validator {

    public static boolean isNotEmpty(Iterable<?> iterable) {
        return null != iterable && iterable.iterator().hasNext();
    }

    public static boolean isEmpty(Iterable<?> iterable) {
        return !isNotEmpty(iterable);
    }

    public static boolean isBlank(String string) {
        return null == string || string.isBlank();
    }

    public static boolean isNotBlank(String string) {
        return !isBlank(string);
    }
}