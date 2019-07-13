package com.ksea.lambda.demo.demo1;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StudentTest {

    //初始化学生集合数据
    private List<Student> students;


    @Before
    public void before() {
        students = Arrays.asList(
                new Student("1", "张三1", 8, 79.0),
                new Student("2", "张三2", 9, 55.0),
                new Student("3", "张三3", 10, 90.0),
                new Student("4", "张三4", 4, 100.0),
                new Student("5", "张三5", 11, 88.0),
                new Student("6", "张三6", 8, 35.0),
                new Student("7", "张三7", 9, 65.0),
                new Student("8", "张三8", 12, 80.0),
                new Student("9", "张三9", 15, 20.0),
                new Student("10", "张三10", 7, 40.0),
                new Student("11", "张三11", 6, 60.0),
                new Student("12", "张三12", 15, 70.7),
                new Student("13", "张三13", 16, 50.1),
                new Student("14", "张三14", 19, 73.3),
                new Student("15", "张三15", 20, 100.0)

        );
    }

    @Test
    public void test1() {
        printStudents(students);
    }


    /**
     * 这个方法是的弊端是，没更改一个需求，就的去对应的增加一个对应的方法，其核心方法过滤变得特别冗余
     */
    @Test
    public void test2() {

        printStudents(StudentTest2.filterStudentByAge(students, 9));

        System.out.println("------------------------------------------------");

        printStudents(StudentTest2.filterStudentByScore(students, 80));

        System.out.println("------------------------------------------------");

        printStudents(StudentTest2.filterStudentBySno(students, "7"));

    }

    /**
     * 为优化test2 提出设计模式 策略模式对其优化
     */
    @Test
    public void test3() {

        printStudents(new StudentByAge().filterList(students, 9));
        System.out.println("----------------------------------------------");
        printStudents(new StudentByScore().filterList(students, 75.0));
        System.out.println("----------------------------------------------");
        printStudents(new StudentBySno().filterList(students, "11"));

        System.out.println("-----------------------年龄-------------------");
        //上面的方式是依托了起jva的特性 default默认接口进行实现，接下来是使用策略模式进行,这个方式是依据于匿名内部类的策略方式获取年龄方式
        printStudents(new StrategyPattern<Student, Integer>().filter(students, 9, new PredicateCondition<Student, Integer>() {
                    @Override
                    public boolean predicate(Student student, Integer condition) {
                        return student.getAge() > condition;
                    }
                })
        );

        System.out.println("-----------------------学分-------------------");
        printStudents(new StrategyPattern<Student, Double>().filter(students, 77.8, new PredicateCondition<Student, Double>() {
                    @Override
                    public boolean predicate(Student student, Double condition) {
                        return student.getScore() > condition;
                    }
                })
        );
    }


    /**
     * java 8 lambda
     */
    @Test
    public void test4() {

        //用lambda实现其非常简洁的过滤根据年龄
        printStudents(new StrategyPattern<Student, Integer>().filter(students, 12, (student, c) -> student.getAge() > c));
        System.out.println("--------------------------------------------------------------------------------------------");
        printStudents(new StrategyPattern<Student, Double>().filter(students, 85.0, (student, score) -> student.getScore() >= score));

    }

    public void printStudents(List<Student> students) {
        students.forEach(System.out::println);
    }
}
