package com.codingzx.多线程.线程同步;

import lombok.var;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var taskQueue = new TaskQueue();
        var threadArrayList = new ArrayList<Thread>();
        for (int i = 0; i < 5; i++) {
            var t = new Thread() {
                public void run() {
                    // 执行task:
                    while (true) {
                        try {
                            String s = taskQueue.getTask();   // 执行五次
                            System.out.println("execute task: " + s);
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                }
            };
            t.start();
            threadArrayList.add(t);
        }
        var add = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // 放入task:
                String randomstring = "t-" + Math.random();
                System.out.println("add task: " + randomstring);
                taskQueue.addTask(randomstring);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        });
        add.start();
        add.join();
        Thread.sleep(100);
        for (var t : threadArrayList) {
            t.interrupt();
        }
    }
}

class TaskQueue {
    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        this.queue.add(s);
        this.notifyAll();
    }

    public synchronized String getTask() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println(Thread.currentThread()+"队列当前为空，正在等待");
            this.wait();
        }
        return queue.remove();
    }
}
