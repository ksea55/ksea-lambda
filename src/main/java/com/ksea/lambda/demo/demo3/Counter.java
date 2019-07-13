package com.ksea.lambda.demo.demo3;

/**
 * 声明一个Counter
 * 函数
 */
@FunctionalInterface
public interface Counter<T> {
    /**
     * 得到两个数的一个结果
     *
     * @param t1
     * @param t2
     * @return
     */
    Integer getResult(T t1, T t2);
}
