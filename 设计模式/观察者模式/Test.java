package com.codingzx.设计模式.观察者模式;

/**
 * @author created by zhangxin27695
 * @Classname Test
 * @Description
 * 当对象间存在一对多关系时，则使用观察者模式（Observer Pattern）。比如，当一个对象被修改时，则会自动通知依赖它的对象。观察者模式属于行为型模式。
 * @Date 2020-07-28 19:36
 */
public class Test {

    public static void main(String[] args) {
        Watchfirst first = new Watchfirst();
        Watchsecond second = new Watchsecond();
        Watch watch = new Watch();

        watch.addPerson(first);
        watch.addPerson(second);

        watch.notifyPerson();


    }
}
