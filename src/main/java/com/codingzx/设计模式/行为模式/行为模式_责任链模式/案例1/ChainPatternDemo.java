package com.codingzx.设计模式.行为模式.行为模式_责任链模式.案例1;

/**
 * @author codingzx
 * @description
 * @date 2021/9/11 14:40
 */
public class ChainPatternDemo {

    private static AbstractLogger getChainOfLoggers(){

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);   // 3
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);     // 2
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);// 1

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        // ERROR   - >    FILE    - > CONSOLE
        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");

        loggerChain.logMessage(AbstractLogger.DEBUG,
                "This is a debug level information.");

        loggerChain.logMessage(4,
                "This is an error information.");
    }
}
