package com.codingzx.leetcode.company;

import com.codingzx.leetcode.company.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author created by zhangxin27695
 * @Classname main
 * @Description
 * @Date 2019-11-18 19:17
 */
public class main {

    public static void main(String[] args) {

//        String s = "HG[3|B[2|CA]]F";
//        Stack<Integer> numStack = new Stack<>();
//        Stack<String> strStack = new Stack<>();
//        int num =0;
//        StringBuffer sb = new StringBuffer("");
//        for(int i =0;i<s.length();i++){
//            char c = s.charAt(i);
//            if(c<='9'&&c>='0'){
//                num=10*num + c-'0';
//            }else if(c=='|'){
//                numStack.push(num);
//                num = 0;
//            }else if(c<='Z'&&c>='A'){
//                sb.append(c);
//            }else if(c=='['){
//                strStack.push(sb.toString());//暂存供遇到 ] 时合并生成新的子串
//                sb=  new StringBuffer("");;
//            }else{
//                num = numStack.pop();
//                StringBuffer tmp = new StringBuffer(strStack.pop());
//                while(num>0){
//                    tmp.append(sb.toString());
//                    num--;
//                }
//                sb=new StringBuffer(tmp.toString());
//            }
//
//        }
//        System.out.println(sb.toString());

        Student student1 = new Student(10, "Start");
        Student student2 = new Student(20, "Start");
        Student student3 = new Student(30, "Start");
        Student student4 = new Student(50, "Start");
        ArrayList<Student> listStudent = new ArrayList<>();
        listStudent.add(student1);
        listStudent.add(student2);
        listStudent.add(student3);
        listStudent.add(student4);
//        for (Student tmp : listStudent) {
//            System.out.println(tmp);
//        }
//        listStudent.stream().filter(e -> {
//            if (e.getAge() > 20) {
//                return false;  // false会过滤不适合的情况
//            }
//            return true;
//        }).forEach(e->{
//            System.out.println(e);
//        });
        ArrayList<Student> listStudent2= (ArrayList<Student>) listStudent.stream().filter(e -> {
            if (e.getAge() > 20) {
                return false;  // false会过滤不适合的情况
            }
            return true;
        }).collect(Collectors.toList());
        for (Student tmp : listStudent2) {
            System.out.println(tmp);
        }
//        listStudent.stream().filter(Boolean::)
    }
}
