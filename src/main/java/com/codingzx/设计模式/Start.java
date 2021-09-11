package com.codingzx.设计模式;

import java.util.Scanner;

/**
 * @author created by zhangxin27695
 * @Classname Start
 * @Description 总体来说设计模式分为三大类：
 * 创建型模式，共五种：
 * 1. 工厂方法模式
 * 2.抽象工厂模式
 * 3.单例模式     {@link com.codingzx.设计模式.创建模式.创建模式_单例模式.hello}
 * 4.建造者模式
 * 5.创建模式。
 * ===============================================================================
 * 结构型模式，共七种：
 * 1.适配器模式
 * 2.装饰器模式
 * 3.结构模式_代理模式
 * 4.外观模式
 * 5.桥接模式
 * 6.组合模式
 * 7.享元模式
 * ===============================================================================
 * 行为型模式，共十一种：
 * 1.行为模式_策略模式
 * 2.模板方法模式
 * 3.行为模式_观察者模式
 * 4.迭代子模式
 * 5.责任链模式
 * 6.命令模式
 * 7.备忘录模式
 * 8.状态模式
 * 9.访问者模式
 * 10.中介者模式
 * 11.解释器模式
 * @Date 2020-06-16 11:21
 */
public class Start {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int k = 0;
        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= i; j++) {
                k++;
                if (k == target) {
                    System.out.println("结果是" + j);
                    break;
                }
            }


        }


    }
}
