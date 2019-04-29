package com.bfd.bookdemo.t6;

public class Run1 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

    }

}


class MyThread extends Thread {
    public MyThread() {
        System.out.println("构造方法打印：" + Thread.currentThread().getName());
    }


    public void run() {
        System.out.println("run方法打印：" + Thread.currentThread().getName());
    }
}

class Run2 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

    }

}
