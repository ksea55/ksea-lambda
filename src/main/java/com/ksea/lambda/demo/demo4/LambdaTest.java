package com.ksea.lambda.demo.demo4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 测试java中内置的四大核心接口
 */
public class LambdaTest {


    @Test
    public void test1() {

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        increment(nums, x -> System.out.println("这个在实际中，比如说消息队列，消费消息队列中的数据，进行对应的处理,处理了" + x));
    }

    //consumer 消费者行接口 一个参数，无返回值
    public void increment(List<Integer> list, Consumer<Integer> consumer) {
        list.forEach(x -> consumer.accept(x));
    }


    @Test
    public void test2() {

        //产生一个自定大小的随机数组
        List<Integer> list = get(3, () -> (int) (Math.random() * 100));
        list.forEach(x -> System.out.println(x));

    }

    //返回一个指定大小长度的数组
    public List<Integer> get(Integer num, Supplier<Integer> sup) {
        List<Integer> ints = new ArrayList<>();
        for (int i = 0; i < num; i++) {

            ints.add(sup.get());
        }
        return ints;
    }


    @Test
    public void test3() {
        System.out.println(handerString("aaaaaaaaaaaaaa", x -> x.toUpperCase()));
    }

    //函数式接口
    public String handerString(String src, Function<String, String> hander) {
        return hander.apply(src);
    }


    @Test
    public void test4() {

        List<String> srclist = Arrays.asList("Hello", "AAAAAAAAAAA", "BB", "CCCC", "AB", "DDDD");
        filter(srclist, x -> x.length() > 5).forEach(x -> System.out.println(x));
    }

    public List<String> filter(List<String> srclist, Predicate<String> p) {
        List<String> return_list = new ArrayList<>();
        srclist.forEach(x -> {
            if (p.test(x)) {
                return_list.add(x);
            }
        });
        return return_list;
    }

}
