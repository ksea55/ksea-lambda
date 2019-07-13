package com.ksea.lambda.demo.demo1;

import java.util.ArrayList;
import java.util.List;

public class StudentTest2 {

    /**
     * 根据指定年龄过滤学生信息
     *
     * @param students
     * @param age
     * @return
     */
    public static List<Student> filterStudentByAge(List<Student> students, Integer age) {
        List<Student> templist = new ArrayList<>();
        for (Student student : students) {
            if (student.getAge() > age) {
                templist.add(student);
            }
        }
        return templist;
    }

    /**
     * 根据学分过滤学生信息
     *
     * @param students
     * @param score
     * @return
     */
    public static List<Student> filterStudentByScore(List<Student> students, double score) {
        List<Student> templist = new ArrayList<>();
        for (Student student : students) {
            if (student.getScore() > score) {
                templist.add(student);
            }
        }
        return templist;
    }

    /**
     * 根据学号进行过滤学员信息
     *
     * @param students
     * @param sno
     * @return
     */
    public static List<Student> filterStudentBySno(List<Student> students, String sno) {
        List<Student> templist = new ArrayList<>();
        for (Student student : students) {
            if (Integer.parseInt(student.getSno()) > Integer.parseInt(sno)) {
                templist.add(student);
            }
        }
        return templist;
    }
}
