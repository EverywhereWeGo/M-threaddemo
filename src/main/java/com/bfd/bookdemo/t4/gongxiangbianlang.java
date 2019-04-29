package com.bfd.bookdemo.t4;

class Myteread1 extends Thread {
    private int count = 5;


    synchronized public void run() {
        super.run();
        count--;
        System.out.println("由" + this.currentThread().getName() + "计算，count=" + count);
    }
}


public class gongxiangbianlang {
    public static void main(String[] args) {
        Myteread1 myteread1 = new Myteread1();
        Thread a = new Thread(myteread1, "A");
        Thread b = new Thread(myteread1, "B");
        Thread c = new Thread(myteread1, "C");
        Thread d = new Thread(myteread1, "D");
        Thread e = new Thread(myteread1, "E");


        a.start();
        b.start();
        c.start();
        d.start();
        e.start();


    }
}
