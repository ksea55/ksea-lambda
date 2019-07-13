package com.ksea.lambda.demo.demo3;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentTest {

    //初始化学生集合数据
    private List<Student> students;


    @Before
    public void before() {
        students = Arrays.asList(
                new Student("1", "张三1", 8, 79.0),
                new Student("2", "张三2", 9, 55.0),
                new Student("3", "张三4", 10, 90.0),
                new Student("4", "张三4", 4, 100.0),
                new Student("5", "张三5", 11, 88.0),
                new Student("6", "张三6", 8, 35.0),
                new Student("7", "张三7", 9, 65.0),
                new Student("8", "张三9", 12, 80.0),
                new Student("9", "张三9", 15, 20.0),
                new Student("10", "张三10", 7, 40.0),
                new Student("11", "张三11", 6, 60.0),
                new Student("12", "张三12", 15, 70.7),
                new Student("13", "张三13", 16, 50.1),
                new Student("14", "张三14", 19, 73.3),
                new Student("15", "张三15", 20, 100.0)

        );
    }

    /**
     * 练习 通过Lambda的方式对学生进行排序，先按年龄排序然后在根据学分排序
     */
    @Test
    public void test2() {

        Collections.sort(students, (s1, s2) -> s1.getAge().equals(s2.getAge()) ? (int) (s1.getScore() - s2.getScore()) : s1.getAge() - s2.getAge());

        students.forEach(student -> System.out.println(student));

    }


    @Test
    public void test3() {
        Collections.sort(students, (s1, s2) -> s1.getName().equals(s2.getName()) ? -s1.getScore().compareTo(s2.getScore()) : s1.getName().compareTo(s2.getName()));
        students.forEach(student -> System.out.println(student));
    }

}
