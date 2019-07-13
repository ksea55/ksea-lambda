package com.ksea.lambda.demo.demo2;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaTest {


    @Test
    public void test() {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("传统方式是以匿名内部类实现其 Runnable接口");
            }
        };

        runnable.run();

        //通过lambda进行实现,其实Lambda其实是函数是编程，对其接口的实现
        Runnable r = () -> System.out.println("以Lambda 的方式进行实现其接口");
        r.run();


    }


    @Test
    public void test1() {
        /**
         * test()方式中的这种实现，其Lammbda的语法法则一
         * 无参无返回值，起接口只有一个接口,
         * 如在ICar中有2个接口的时候，在使用Lambda的这种形式，就会报错
         * 通常我们用
         @FunctionalInterface注解来进行标注起是函数式接口，如果有多个可以在编译期间就提前发现
         */
        ICar i = () -> System.out.println("---------------------");
        i.run();

    }


    @Test
    public void test2() {

        /**
         *
         * 针对函数式编程，java也默认为我们提供了一些系统内置接口如 当前无返回值的接口
         *
         */
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("xxxxxxxxxxxxxxx");
    }


    @Test
    public void test3() {

        List<Integer> list = Arrays.asList(1, 23, 4, 5, 6, 7, 8, 8, 8, 8, 8, 9994, 45, 4545, 5, 66);
        list.forEach((x) -> System.out.println(x));

        System.out.println("------------------------------");
        list.forEach(x -> System.out.println(x));


        /***
         *
         *
         * 从forEach中在JAVA8中 其循环，将每个元素 起实现了Consumer接口，左侧如果只有一个参数可以不写(),x-> 与(x)->一致的
         *
         */


    }


}
