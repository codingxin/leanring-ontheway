package com.codingzx.线程同步;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author codingzx
 * @description
 * @date 2021/4/26 20:18
 */
public class TestVolidate {
    public int inc = 0;

    public void increase() {
        synchronized (this) {
            inc++;
        }
    }

    public void dec() {
        synchronized (this) {
            inc--;
        }
    }

    public static void main(String[] args) {
        AtomicInteger atomicInt = new AtomicInteger(100);
        atomicInt.compareAndSet(100, 101);
        atomicInt.compareAndSet(101, 100);
        System.out.println("new value = " + atomicInt.get());
        boolean result1 = atomicInt.compareAndSet(100, 101);
        System.out.println(result1); // result:true

        AtomicInteger v1 = new AtomicInteger(100);
        AtomicInteger v2 = new AtomicInteger(101);
        AtomicInteger v3 = new AtomicInteger(102);
        AtomicStampedReference<AtomicInteger> stampedRef = new AtomicStampedReference<AtomicInteger>(v1, 0);

        int stamp = stampedRef.getStamp();
        stampedRef.compareAndSet(v1, v2, stampedRef.getStamp(), stampedRef.getStamp() + 1);
        System.out.println("版本号" + stampedRef.getStamp());
        stampedRef.compareAndSet(v2, v1, stampedRef.getStamp(), stampedRef.getStamp() + 1);
        System.out.println("版本号" + stampedRef.getStamp());
        System.out.println("new value = " + stampedRef.getReference());
        boolean result2 = stampedRef.compareAndSet(v3, v1, stampedRef.getStamp(), stamp + 1);
        System.out.println("版本号" + stampedRef.getStamp());
        System.out.println(result2); // result:false
        System.out.println("new value = " + stampedRef.getReference());

    }


//    private Entry<E> addBefore(E e, Entry<E> entry) {
//        Entry newEntry = new Entry(e, e, e.prious);
//        newEntry.prious.next = newEntry;
//        newEntry.next.prious = newEntry;
//        mod++;
//        size++;
//    }
//
//
//    void linkLast(E e) {
//        final Node l = last;
//        final Node newNode = new Node(l, e, null);
//        if (l == null) {
//            first = newNode;
//        } else {
//            l.next = newNode;
//        }
//        mod++;
//        sieze++;
//    }


//    public static void main(String[] args) {
//        final TestVolidate testVolidate = new TestVolidate();
//        for (int i = 0; i < 20; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    testVolidate.increase();
//                }
//            }).start();
//        }
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(testVolidate.inc);
//        for (int i = 0; i < 20; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    testVolidate.dec();
//                }
//            }).start();
//        }
//
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
////        while(Thread.activeCount()>1)  //保证前面的线程都执行完
////            Thread.yield();
//        System.out.println(testVolidate.inc);
//    }

}
