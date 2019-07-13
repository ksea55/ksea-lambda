package com.ksea.lambda.demo.demo3;

/**
 * 声明一个用于计算的函数
 *
 * @param <T> 传入类型
 * @param <R> 返回类型
 */
@FunctionalInterface
public interface ICompute<T, R> {

    R counter(T t1, T t2);
}
