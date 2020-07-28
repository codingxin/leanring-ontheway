package com.codingzx.leetcode.hello01;

/**
 * @author created by zhangxin27695
 * @Classname Test2
 * @Description
 * @Date 2019-11-20 14:12
 */
class Test2 {
    public static void main(String[] args) {
        float[] a[]=new float[6][6];
        float []f[] = new float[6][6];
        float [][]c = new float[6][];

        System.out.println(new B().getValue());
    }
    static class A {
        //实例化什么对象调用什么方法
        protected int value;
        public A (int v) {
            //第一次调用的是父类的方法 因为此时是实例化 父类的对象 1
            setValue(v);
        }
        public void setValue(int value) {
            this.value= value;
        }
        public int getValue() {
            try {
                value ++;
                return value; //返回变化之前的值 value ==11
            } finally {
                this.setValue(value);   //调用子类的方法 因为此时实例化子类对象（this表当前对象，B的setValue方法）
                System.out.println(value);
            }
        }
    }
    static class B extends A {
        public B () {
            super(5);
            setValue(getValue()- 3); //B类没有重写的getValue方法 所以调用 父类的getValue方法
        }
        public void setValue(int value) {
            super.setValue(2 * value);  //2
        }
    }
}
