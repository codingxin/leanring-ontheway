package com.codingzx.设计模式.行为模式.行为模式_观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @author created by zhangxin27695
 * @Classname Watch
 * @Description
 * @Date 2020-07-28 19:33
 */
public class Watch {

    List<Person> list = new ArrayList<>();


    public Watch() {
    }

    public void addPerson(Person person) {
        list.add(person);
    }

    // 遍历list，把自己的通知发送给所有观察者
    public void notifyPerson() {
        for (Person person : list) {
            person.getMessage("你们都观察到我了");
        }
    }

}
