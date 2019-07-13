package com.ksea.lambda.demo.demo1;

/**
 * 根据指定年龄过滤其学生信息
 */
public class StudentByAge implements Predicate<Student, Integer> {
    @Override
    public boolean predicate(Student student, Integer integer) {
        return student.getAge() >= integer;
    }
}
