//package com.codingzx.线程综合.中断线程.InterruptThread;
//
//import javafx.concurrent.Task;
//
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author codingzx
// * @description
// * @date 2022/2/20 16:25
// */
//public class TaskRunner implements Runnable {
//    private BlockingQueue<Task> queue;
//
//    public TaskRunner(BlockingQueue<Task> queue) {
//        this.queue = queue;
//    }
//
//    public void run() {
//        try {
//            while (true) {
//                Task task = queue.take(10, TimeUnit.SECONDS);
//                task.execute();
//            }
//        } catch (InterruptedException e) {
//            // Restore the interrupted status
//            Thread.currentThread().interrupt();
//        }
//    }
//}
