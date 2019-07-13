package com.ksea.lambda.demo.demo1;

import java.util.ArrayList;
import java.util.List;

public class StrategyPattern<T, C> {

    public List<T> filter(List<T> list, C c, PredicateCondition<T, C> p) {

        List<T> templist = new ArrayList<>();
        for (T t : list) {
            if (p.predicate(t, c)) {
                templist.add(t);
            }

        }
        return templist;
    }

}
