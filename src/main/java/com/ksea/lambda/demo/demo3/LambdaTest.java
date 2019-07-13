package com.ksea.lambda.demo.demo3;

import org.junit.Test;

/**
 * 总结：Lambda表达式 其实是函数式编程
 * 它是对一个接口的匿名实现 可以这样说
 * 可以是说 匿名内部类的的升级版本
 */
public class LambdaTest {

    @Test
    public void test() {

        /**
         * Lambda其实就是对一个函数的匿名实现
         */
        Counter<Integer> sum = (x, y) -> x + y;
        System.out.println(sum.getResult(1, 2));

        //两者是相同的
        Counter<Integer> sum1 = new Counter<Integer>() {
            @Override
            public Integer getResult(Integer t1, Integer t2) {
                return t1 + t2;
            }
        };

        System.out.println(sum1.getResult(2, 3));


        //在Lambda中，如果左侧和右侧都只有一个执行的时候，方法体中也只有一个执行语句的是后{},与return是可以省略不写的
        Counter<Integer> sub = (x, y) -> x - y;
        System.out.println(sub.getResult(100, 2));

    }

    /**
     * 声明一个函数接口，并返回字符串
     */
    @Test
    public void test2() {

        //返回一个 转大写的字符串
        System.out.println(strHander("AAAAAAAAAAAAAAAA", x -> x.toLowerCase()));


    }

    public String strHander(String src, IString<String> hander) {
        return hander.getValue(src);
    }


    @Test
    public void test3() {

        System.out.println(compute(1, 2, (x, y) -> x + y));
        System.out.println(compute(1, 2, (x, y) -> x - y));
        System.out.println(compute(1, 2, (x, y) -> x * y));
        System.out.println(compute(1, 2, (x, y) -> x / y));
        System.out.println(compute(1, 2, (x, y) -> x % y));

    }

    public Integer compute(Integer s1, Integer s2, ICompute<Integer, Integer> hander) {
        return hander.counter(s1, s2);
    }

}
