package com.codingzx.leetcode.hello01;

/**
 * @author created by zhangxin27695
 * @Classname Value
 * @Description
 * @Date 2019-11-19 16:47
 */
class Value{
    public int i=15;
}
public class Test{
    public static int count=0;
    public static void main(String argv[]){
        Test t=new Test( );
        t.first( );

//        int i = 7;
//        do {
//            System.out.println(--i);
//            --i;
//        } while (i != 0);
//        System.out.println(count);
        String a = "123"; String b = "123";
        System.out.println(a==b);

        char myChar = 'g';
        String myStr = Character.toString(myChar);
        System.out.println("String is: "+myStr);
        myStr = String.valueOf(myChar);
        System.out.println("String is: "+myStr);
    }

    public void first( ){
        int i=5;
        Value v=new Value( );
        v.i=25;
        second(v,i);
        System.out.println(v.i);
    }

    public void second(Value v,int i){
        //v 已经是新变量，但是会改变原来的值
        i = 0;
        v.i = 20;
        Value val = new Value( );
        v = val;
        System.out.println(v.i+" "+i); //15 0 20
    }
}

