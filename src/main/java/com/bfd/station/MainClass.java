package com.bfd.station;

public class MainClass{
    Station station1 = new Station("窗口1");
    Station station2 = new Station("窗口2");
    Station station3 = new Station("窗口3");




}
class Station extends Thread {
    Station(String name) {
        super(name);
    }

    static int tick = 200;
    static Object ob = "";


    public void run() {
        while (tick > 0) {
            synchronized (ob) {
                if (tick > 0) {
                    System.out.println(getName() + "卖出了第" + tick + "票");
                    tick--;
                } else {
                    System.out.println("票卖完了");
                }

            }
        }
    }
}
