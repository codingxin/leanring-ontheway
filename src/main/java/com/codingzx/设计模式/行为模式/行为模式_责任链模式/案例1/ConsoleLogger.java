package com.codingzx.设计模式.行为模式.行为模式_责任链模式.案例1;

/**
 * @author codingzx
 * @description
 * @date 2021/9/11 14:39
 */

public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("标准输出: Standard Console::Logger: " + message);
    }
}