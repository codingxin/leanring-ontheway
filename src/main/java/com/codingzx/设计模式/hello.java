package com.codingzx.设计模式;

import java.util.Scanner;

/**
 * @author created by zhangxin27695
 * @Classname hello
 * @Description 总体来说设计模式分为三大类：
 * 创建型模式，共五种：工厂方法模式、抽象工厂模式、单例模式、建造者模式、原型模式。
 * 结构型模式，共七种：适配器模式、装饰器模式、代理模式、外观模式、桥接模式、组合模式、享元模式。
 * 行为型模式，共十一种：策略模式、模板方法模式、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模
 * 式、状态模式、访问者模式、中介者模式、解释器模式
 * @Date 2020-06-16 11:21
 */
public class hello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target=scanner.nextInt();
        int k=0;
        for(int i=1;i<=target;i++){
            for(int j=1;j<=i;j++){
                k++;
                if(k==target){
                    System.out.println("结果是"+j);
                    break;
                }
            }


        }


    }
}
