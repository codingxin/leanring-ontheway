package com.codingzx.hellolearnig.leetcode;
//
///**
// * @author created by zhangxin27695
// * @Classname hello
// * @Description
// * @Date 2020-05-12 14:50
// */
//public class hello {
//
////    public static boolean isAdmin(String userId){
////        System.out.println(userId.toLowerCase());
////        return userId.toLowerCase()=="admin";
////    }
////    public static void main(String[] args){
////        System.out.println(isAdmin("Admin"));
////    }
//
//
//    private static final String MESSAGE = "taobao";
//
//    public static void main(String[] args) {
////        Object obj=new Object();
////        String a ="tao"+"bao";
////        String b="tao";
////        String c="bao";
////        System.out.println(a==MESSAGE);
////        System.out.println((b+c)==MESSAGE);
////        String a = "hello";
////        String b = "abc";
////        String c = a + b;
////        String d = new String("helloabc");
////        System.out.println((a + b).equals(c));
////        System.out.println(a + b == c);
////        System.out.println(c == d);
////        System.out.println(c.equals(d));
//        System.out.println(Integer.valueOf("8"));
//        System.out.println('8'-'0');
//        System.out.println(Integer.valueOf('8'-'0'));
//
//    }
//
//
//}
//
import java.util.*;


public class hello{


    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            int n=input.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=input.nextInt();
            }
            int blog=input.nextInt();
            if (blog==0) {
                Arrays.sort(a);
            } else {
                //降序，可用Comparator()匿名内部类
//                Arrays.sort(a, (Comparator<Integer>) Comparator.reverseOrder());



            }













        }















    }













}
