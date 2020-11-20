package com.codingzx.Lamda;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class lamda {

    public static void main(String[] args) {

    }


    public void testToMap() {
        Student student1 = new Student();
        student1.setStudentId(1);
        student1.setStudentName("student1");

        Student student2 = new Student();
        student2.setStudentId(1);
        student2.setStudentName("student1");


        Student student3 = new Student();
        student3.setStudentId(1);
        student3.setStudentName("student1");

        List<Student> studentList = new LinkedList<>();
        studentList.add(student1);
        studentList.add(student2);

        studentList.add(student3);
        // 一.      测试新老值导致异常                   =====================
        // 每次采用新值,不加第三个参数   如果key重复的值会报错抛出异常
        Map<Integer, Student> studentMap1 = studentList.stream().collect(Collectors.toMap(Student::getStudentId, newvalue -> newvalue,
                (oldvalue, newvalue) -> newvalue));
        // 每次采用老值
        Map<Integer, Student> studentMap2 = studentList.stream().collect(Collectors.toMap(Student::getStudentId, newvalue -> newvalue,
                (oldvalue, newvalue) -> oldvalue));
        // 每次采用新值
        Map<Integer, Student> studentMap3 = studentList.stream().collect(Collectors.toMap(Student::getStudentId, Function.identity(), (oldvalue, newvalue) -> newvalue));


        // 二.      测试新老值导致异常                   =====================
        Map<Integer, List<Student>> studentMap4 = studentList.stream().filter(e -> e.getStudentId() != null)
                .collect(Collectors.groupingBy(Student::getStudentId));
        for (Map.Entry<Integer, List<Student>> entry : studentMap4.entrySet()) {
            System.out.println("key = " + entry.getKey() + ",vlaue=" + entry.getValue().stream().findAny().map(Student::getStudentId));
        }
        Map<Integer, Student> studentMap5 = studentList.stream().collect(Collectors.toMap(Student::getStudentId, port -> port));
        // 有bug，当ifidx重复时 报key重复错误
        for (Map.Entry<Integer, Student> entry : studentMap5.entrySet()) {
            System.out.println("key1 = " + entry.getKey() + "vlaue1=" + entry.getValue().getStudentName());
        }

        // 三.      测试分组                 =====================
        Map<Integer, List<Student>> wanMap = studentList.stream().collect(Collectors.groupingBy(Student::getStudentId));
    }


}
