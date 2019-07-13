package com.ksea.lambda.demo.demo1;

/**
 * 根据学生编号进行过滤
 */
public class StudentBySno implements Predicate<Student, String> {
    @Override
    public boolean predicate(Student student, String s) {
        return Integer.parseInt(student.getSno()) >= Integer.parseInt(s);
    }
}
