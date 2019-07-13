package com.ksea.lambda.demo.demo1;

/**
 * 根据学分过滤器学生信息
 */
public class StudentByScore implements Predicate<Student, Double> {
    @Override
    public boolean predicate(Student student, Double score) {
        return student.getScore() >= score;
    }
}
