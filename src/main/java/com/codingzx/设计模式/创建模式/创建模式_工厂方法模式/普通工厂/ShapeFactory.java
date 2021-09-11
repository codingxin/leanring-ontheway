package com.codingzx.设计模式.创建模式.创建模式_工厂方法模式.普通工厂;

import com.codingzx.设计模式.创建模式.创建模式_工厂方法模式.entity.Circle;
import com.codingzx.设计模式.创建模式.创建模式_工厂方法模式.entity.Rectangle;
import com.codingzx.设计模式.创建模式.创建模式_工厂方法模式.entity.Shape;
import com.codingzx.设计模式.创建模式.创建模式_工厂方法模式.entity.Square;

/**
 * @author created by zhangxin27695
 * @Classname ShapeFactory
 * @Description
 * 创建一个工厂，生成基于给定信息的实体类的对象
 * @Date 2020-07-30 10:03
 */
public class ShapeFactory {

    //使用 getShape 方法获取形状类型的对象
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
