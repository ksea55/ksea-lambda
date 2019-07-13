package com.ksea.lambda.demo.demo1;

/**
 * @param <T>
 * @param <C>
 */
public interface PredicateCondition<T, C> {

    boolean predicate(T t, C c);
}
