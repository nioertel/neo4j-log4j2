package com.example.neo4j.log4j2;

import java.util.Enumeration;
import java.util.function.Predicate;

public class PredicateEnumeration<T> implements Enumeration<T> {

    private final Predicate<T> predicate;
    private final Enumeration<T> delegate;
    private T next;

    public PredicateEnumeration(Predicate<T> predicate, Enumeration<T> delegate) {
        this.predicate = predicate;
        this.delegate = delegate;
    }

    @Override
    public boolean hasMoreElements() {
        boolean hasNext = delegate.hasMoreElements();
        if (hasNext) {
            next = delegate.nextElement();
            if (predicate.test(next)) {
                return true;
            } else {
                return hasMoreElements();
            }
        } else {
            return false;
        }
    }

    @Override
    public T nextElement() {
        return next;
    }

}
