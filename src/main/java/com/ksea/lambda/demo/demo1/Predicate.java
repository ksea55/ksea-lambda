package com.ksea.lambda.demo.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * 该接口用于提供基于什么条件返回对应的student
 *
 * @param <T> 需要过滤对象
 * @param <C> 过滤条件
 */
public interface Predicate<T, C> {

    boolean predicate(T t, C c);

    /**
     * java8中的默认接口
     *
     * @param list
     * @param c
     * @return
     */
    default List<T> filterList(List<T> list, C c) {
        List<T> templist = new ArrayList<>();
        for (T t : list) {
            if (predicate(t, c)) {
                templist.add(t);
            }

        }
        return templist;
    }
}
