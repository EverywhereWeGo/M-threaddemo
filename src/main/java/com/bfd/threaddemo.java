//package com.bfd;
//
//public class threaddemo {
//    public static void main(String[] args) {
//
//        for (int i = 0; i < 3; i++) {
//            Mythread thread1 = new Mythread();
//            thread1.start();
//
//        }
//
//
//    }
//}
//
//class Mythread1 extends Thread {
//    public void run() {
//        for (int i = 0; i < 100; i++) {
//            System.out.println(Thread.currentThread() + "-->" + i);
//        }
//    }
//}
//
//
//class lliisstt {
//    private String name;
//    private String sex;
//    private boolean set = false;
//
//    public synchronized void set(String name, String sex) {
//        //如果有数据等待
//        if (set) {
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        //没有数据则写入数据
//        this.name = name;
//        this.sex = sex;
//        this.set = true;
//        //通知其他线程来处理数据
//        this.notify();
//    }
//
//    public synchronized void out() {
//        //如果没有数据读，等待
//        if (!set) {
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        //读取数据
//        System.out.println(this.name + "..." + this.sex);
//        set = false;
//        //通知写线程写入数据
//        this.notify();
//    }
//}
//
//
