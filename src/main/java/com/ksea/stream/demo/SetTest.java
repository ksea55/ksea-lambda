package com.ksea.stream.demo;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetTest {

    @Test
    public void test() {

        Set<String> sets = new HashSet<>();
        sets.addAll(Arrays.asList("1", "1", "2", "3", null, null));
        sets.forEach(x -> System.out.println(x));
    }


    @Test
    public void test1() {

        Set<String> ints = new HashSet<>();
        ints.add("2");
        ints.add(1 + "");
        ints.add(4 + "");
        ints.add(3 + "");
        ints.add(6 + "");
        ints.add(5 + "");

        ints.forEach(x -> System.out.println(x));


    }

}
