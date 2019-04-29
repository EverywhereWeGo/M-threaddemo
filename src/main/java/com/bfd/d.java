package com.bfd;

import java.util.LinkedList;
import java.util.List;

public class d {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>();
        synchronized(list){

        }


        Wthread wthread = new Wthread("1", list, 1, 1);
        wthread.start();

        Rthread rthread = new Rthread("2", list, 1, 1);
        rthread.start();


    }
}


class Wthread extends Thread {
    private String threadName;
    private List<Integer> list;
    private int startIndex;
    private int endIndex;

    public Wthread(String threadName, List<Integer> list, int startIndex, int endIndex) {
        this.threadName = threadName;
        this.list = list;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }


    public void run() {
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        System.out.println(threadName + ":" + list.size());
    }
}


class Rthread extends Thread {
    private String threadName;
    private List<Integer> list;
    private int startIndex;
    private int endIndex;

    public Rthread(String threadName, List<Integer> list, int startIndex, int endIndex) {
        this.threadName = threadName;
        this.list = list;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }


    public void run() {
        if (list.size() > 0) {
            System.out.println(threadName + ":" + list.size());
            list.clear();
        } else {
            System.out.println("list内空");
        }
    }
}
