package com.codingzx.设计模式.行为模式.行为模式_策略模式;

import com.codingzx.设计模式.行为模式.行为模式_策略模式.basic.BackDoorIStrategy;
import com.codingzx.设计模式.行为模式.行为模式_策略模式.basic.GivenGreenLightIStrategy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 策略模式的好处就是：体现了高内聚低耦合
 * 策略（Strategy）模式的定义：该模式定义了一系列算法，并将每个算法封装起来，使它们可以相互替换，
 * 且算法的变化不会影响使用算法的客户。策略模式属于对象行为模式，它通过对算法进行封装，把使用算法的责任和算法的实现分割开来，
 * 并委派给不同的对象对这些算法进行管理。
 * <p>
 * 策略模式的主要优点如下。
 * 多重条件语句不易维护，而使用策略模式可以避免使用多重条件语句。
 * 策略模式提供了一系列的可供重用的算法族，恰当使用继承可以把算法族的公共代码转移到父类里面，从而避免重复的代码。
 * 策略模式可以提供相同行为的不同实现，客户可以根据不同时间或空间要求选择不同的。
 * 策略模式提供了对开闭原则的完美支持，可以在不修改原代码的情况下，灵活增加新算法。
 * 策略模式把算法的使用放到环境类中，而算法的实现移到具体策略类中，实现了二者的分离。
 * <p>
 * 其主要缺点如下。
 * 客户端必须理解所有策略算法的区别，以便适时选择恰当的算法类。
 * 策略模式造成很多的策略类。
 * <p>
 * 抽象策略（Strategy）类：定义了一个公共接口，各种不同的算法以不同的方式实现这个接口，环境角色使用这个接口调用不同的算法，一般使用接口或抽象类实现。
 * 具体策略（Concrete Strategy）类：实现了抽象策略定义的接口，提供具体的算法实现。
 * 环境（Context）类：持有一个策略类的引用，最终给客户端调用。
 */
public class Main {

    public static void main(String[] args) {
        Context context = new Context(new BackDoorIStrategy());
        context.operate();
        context = new Context(new GivenGreenLightIStrategy());
        context.operate();

        Map map = new HashMap();
        Collections.synchronizedMap(map);
    }
}
