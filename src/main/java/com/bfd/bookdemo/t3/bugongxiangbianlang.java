package com.bfd.bookdemo.t3;
class Myteread extends Thread {
    private int count = 5;

    public Myteread(String name) {
        super(name);
    }

    public void run() {
        while (count > 0) {
            count--;
            System.out.println("由"+this.currentThread().getName()+"计算，count="+count);
        }
    }
}



public class bugongxiangbianlang{
    public static void main(String[] args ){
        Myteread a = new Myteread("A");
        Myteread b = new Myteread("B");
        Myteread c = new Myteread("C");
        a.start();
        b.start();
        c.start();


    }
}
