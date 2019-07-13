package com.ksea.stream.demo;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {

    private List<Map<String, Object>> entrylist;

    @Before
    public void before() {

        entrylist = new ArrayList<>();
        Map<String, Object> m1 = new HashMap<>();
        m1.put("id", "1");
        m1.put("name", "m1");
        m1.put("wxd", "高");
        m1.put("height", "20");


        Map<String, Object> m2 = new HashMap<>();
        m2.put("id", "2");
        m2.put("name", "m2");
        m2.put("wxd", "高");
        m2.put("height", "230");


        Map<String, Object> m3 = new HashMap<>();
        m3.put("id", "3");
        m3.put("name", "m3");
        m3.put("wxd", "中");
        m3.put("height", "110");



        Map<String, Object> m5 = new HashMap<>();
        m5.put("id", "5");
        m5.put("name", "m5");
        m5.put("wxd", "高");
        m5.put("height", "11");



        Map<String, Object> m4 = new HashMap<>();
        m4.put("id", "5");
        m4.put("name", "m4");
        m4.put("wxd", "高");
        m4.put("height", "20");




        Map<String, Object> m6 = new HashMap<>();
        m6.put("id", "6");
        m6.put("name", "m6");
        m6.put("wxd", "高");
        m6.put("height", "230");


        Map<String, Object> m7 = new HashMap<>();
        m7.put("id", "7");
        m7.put("name", "m7");
        m7.put("wxd", "高");
        m7.put("height", "101");


        Map<String, Object> m8 = new HashMap<>();
        m8.put("id", "8");
        m8.put("name", "m8");
        m8.put("wxd", "中");
        m8.put("height", "30");


        Map<String, Object> m9 = new HashMap<>();
        m9.put("id", "9");
        m9.put("name", "m9");
        m9.put("wxd", "低");
        m9.put("height", "10");


        Map<String, Object> m10 = new HashMap<>();
        m10.put("id", "1");
        m10.put("name", "m1");
        m10.put("wxd", "高");
        m10.put("height", "210");


        entrylist.add(m1);
        entrylist.add(m2);
        entrylist.add(m3);
        entrylist.add(m4);
        entrylist.add(m5);
        entrylist.add(m6);
        entrylist.add(m7);
        entrylist.add(m8);
        entrylist.add(m9);
        entrylist.add(m10);


    }

    @Test //filter
    public void test1() {
        //利用filter过滤出危险度wxd=高 的数据
        List<Map<String, Object>> resultList = entrylist.stream().filter(x -> x.get("wxd").equals("高")).collect(Collectors.toList());
        System.out.println(resultList.size());
        resultList.forEach(x -> System.out.println(x));
        System.out.println("---------------------------------------------------------------------");
        entrylist.forEach(x -> System.out.println(x));
    }


    @Test
    public void test2() {
        //limit截取某段数据

        List<Map<String, Object>> list = entrylist.stream()
                .filter(x -> x.get("wxd").equals("高"))
                .limit(2)
                .collect(Collectors.toList());
        list.forEach(x -> System.out.println(x));
    }


    @Test
    public void test3() {
        //skip跳过某段数据
        List<Map<String, Object>> list = entrylist.stream()
                .filter(x -> x.get("wxd").equals("高"))
                .skip(2)
                .collect(Collectors.toList());
        list.forEach(x -> System.out.println(x));
    }


    @Test
    public void test4() {
        //利用limit与skip进行stream分页操作

        List<Map<String, Object>> list = entrylist.stream()
                .filter(x -> x.get("wxd").equals("高"))
                .skip(4) //相当于index
                .limit(2) //相当于pagesize
                .collect(Collectors.toList());
        list.forEach(x -> System.out.println(x));
    }


    @Test
    public void test5() {
        //limit截取某段数据
        List<Map<String, Object>> list = entrylist.stream()
                .filter(x -> x.get("wxd").equals("高"))
                .distinct()  //在java8中distinct是需要进行对象的equlas与hashcode的重写的
                .collect(Collectors.toList());
        list.forEach(x -> System.out.println(x));
    }


    @Test
    public void test6() {
        //limit截取某段数据
        List<Map<String, Object>> result_list = distinct(entrylist);
        result_list.forEach(x -> System.out.println(x));

    }


    /**
     * @param list
     * @return
     */
    public List<Map<String, Object>> distinct(List<Map<String, Object>> list) {
        Set<Map<String, Object>> s = new TreeSet<Map<String, Object>>(new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                return o1.get("id").toString().compareTo(o2.get("id").toString());
            }

        });

        s.addAll(list);
        return new ArrayList<Map<String, Object>>(s);
    }


    @Test
    public void test7() {
        entrylist.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.get("id") + ""))), ArrayList::new)
        ).forEach(x -> System.out.println(x));

    }

    @Test
    public void test8() {
        entrylist.stream()
                .filter(x -> x.get("wxd").equals("高"))
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.get("id") + ""))), ArrayList::new)
                ).forEach(x -> System.out.println(x));

    }
}