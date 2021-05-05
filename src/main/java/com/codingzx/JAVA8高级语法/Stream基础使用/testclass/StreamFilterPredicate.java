//package com.codingzx.JAVA8高级语法.Stream基础使用.testclass;
//
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * @author created by zhangxin27695
// * @Classname StreamFilterPredicate
// * @Description
// * @Date 2020-04-08 11:37
// */
//public class StreamFilterPredicate {
//
//    public static void main(String[] args) {
//        Employee e1 = new Employee(1, 23, "M", "Rick", "Beethovan");
//        Employee e2 = new Employee(2, 13, "F", "Martina", "Hengis");
//        Employee e3 = new Employee(3, 43, "M", "Ricky", "Martin");
//        Employee e4 = new Employee(4, 26, "M", "Jon", "Lowman");
//        Employee e5 = new Employee(5, 19, "F", "Cristine", "Maria");
//        Employee e6 = new Employee(6, 15, "M", "David", "Feezor");
//        Employee e7 = new Employee(7, 68, "F", "Melissa", "Roy");
//        Employee e8 = new Employee(8, 79, "M", "Alex", "Gussin");
//        Employee e9 = new Employee(9, 15, "F", "Neetu", "Singh");
//        Employee e10 = new Employee(10, 45, "M", "Naveen", "Jain");
//
//
//        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
//
//        //表达过滤年龄大于70并且男性的Employee员工
//        List<Employee> employees2 = employees.stream()
//                .filter(s -> s.getAge() > 70 && s.getGender().equals("M"))
//                .collect(Collectors.toList());
//
//
//        //谓词逻辑的复用
//        // and or negate
//        /**  negate的使用
//         * 前面不加 后面加 前面，后面都取反
//         * 前面加 后面加 前期取正后面取反
//         * 前面加 后面不加 前期取反 后面正
//         * 前面不加 后面不加 都取正
//         */
//        List<Employee> filtemployees = employees.stream().
//                filter(Employee.ageGreaterThan70.and(Employee.genderM)).
//                collect(Collectors.toList());
//
//
//        //打印一
//        filtemployees.forEach(System.out::println);
//        //打印二
////        System.out.println(filtemployees);
//        //打印三
//        employees2.forEach(e -> {
//            System.out.println("hello"+e);
//        });
//
//        System.out.println(employees);
//    }
//}
