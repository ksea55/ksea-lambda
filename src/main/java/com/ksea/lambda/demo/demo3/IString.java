package com.ksea.lambda.demo.demo3;

/**
 * 声明一个字符串函数，并返回已给字符串
 */
@FunctionalInterface
public interface IString<T> {

    T getValue(T t);
}
