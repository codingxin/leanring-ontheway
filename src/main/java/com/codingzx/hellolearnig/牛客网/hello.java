package com.codingzx.hellolearnig.牛客网;

import com.codingzx.hellolearnig.牛客网.继承.A;
import com.codingzx.hellolearnig.牛客网.继承.B;
import com.codingzx.hellolearnig.牛客网.继承.Person;

/**
 * @author created by zhangxin27695
 * @Classname hello
 * @Description
 * @Date 2020-05-21 9:25
 */
public class hello {

    //    public static void main(String) {
//        B b = (B) new A();   // 子类的引用 执行父类的对象 需要强转  向
//        A a = new B();   //里氏替换原则 可以用父类的地方都可以用子类
//    }
    public static void main(String args[]) {

        int a = 10;
        Person person = new Person();
        person.age = 20;

        change(a, person);
        System.out.println("a=" + a + ",and person.age = " + person.age);
        String a1 = "123";
        a1 = "21321";
        System.out.println(a1);

        int x = 1, y = 2, z = 3;
        final int a2 = 3, b2 = 4;
        int c3=a2+b2;
//        Integer a=1;
//        System.out.println(a==1?"等于":"不等于"); //  System.out.println(a.intValue()==1?"等于":"不等于"); 输出等于
//        Boolean bool=false;
//        System.out.println(bool?"真":"假"); //System.out.println(bool.booleanValue?"真":"假");  输出假

//        System.out.println(y＋＝ z－－/＋＋x);

    }

    static void change(int a1, Person person) {

        a1 = 11;
        person.age = 21;
        System.out.println("a1=" + a1 + ",and age1 = " + person);

    }

}
