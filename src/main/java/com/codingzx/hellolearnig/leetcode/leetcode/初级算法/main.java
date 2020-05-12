package com.codingzx.hellolearnig.leetcode.leetcode.初级算法;

/**
 * @author created by zhangxin27695
 * @Classname main
 * @Description
 * new B() ->[super(5)(显示调用父类)->setValue(5)->
 * (调用子类重写的的setValue(5)->super.setValue(10)-> this.value= 10)
 * ->[setValue(getValue()-3){setValue([getValue()(调用父类的方法)
 * value++(value = 11,return value = 11),执行finally{
 * this.setValue(11)调用子类的setValue(11)->(super.setValue(22) Sysout.system.out(22))
 * ->[ setValue(11-3)(return 的是11)]setValue(8) ->super.setValue(2 * 8) )->
 * super.setValue(16) this.value = 16;
 * (new B()).getValue())->value ++->return value ;return value值(value=17 )->finally (this.setValue(17 *2)System.out.print(34))
 * ->System.out.print(new B().getValue));System.out.print(17)
 * @Date 2019-11-12 11:13
 */
class main {
    public static void main(String[] args) {
        System.out.println(new B().getValue());
    }
    static class A {
        protected int value;
        public A (int v) {
            setValue(v);
        }
        public void setValue(int value) {
            this.value= value;
        }
        public int getValue() {
            try {
                value ++;
                return value;
            } finally {
                this.setValue(value);
                System.out.println(value);
            }
        }
    }
    static class B extends A {
        public B () {
            /**
             * 一是虽然构造函数是A类的构造函数，但此刻正在初始化的对象是B的一个实例，
             * 因此这里调用的实际是B类的setValue方法，于是调用B类中的setValue方法 ==>
             * 而B类中setValue方法显示调用父类的setValue方法，将B实例的value值设置为2 x 5 = 10。
             */
            super(5);
            setValue(getValue()- 3);
        }
        public void setValue(int value) {
            super.setValue(2 * value);
        }
    }
}
