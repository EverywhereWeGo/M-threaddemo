package com.bfd;

class Resource {
    private String name;
    private String sex;
    private boolean set = false;

    public synchronized void set(String name, String sex) {
        //如果有数据等待
        if(set) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //没有数据则写入数据
        this.name = name;
        this.sex = sex;
        this.set = true;
        //通知其他线程来处理数据
        this.notify();
    }

    public synchronized void out() {
        //如果没有数据读，等待
        if(!set) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //读取数据
        System.out.println(this.name + "..." + this.sex);
        set = false;
        //通知写线程写入数据
        this.notify();
    }
}

class Input extends Thread {
    private Resource r;

    public Input(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        boolean flag = true;
        while (true) {
            if (flag) {
                r.set("刘备","男");
            } else {
                r.set("小乔","女");
            }
            flag = !flag;
        }
    }
}

class Output extends Thread {
    private Resource r;

    public Output(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.out();
        }
    }
}

public class ResourceDemo {
    public static void main(String[] args) {

        //创建资源
        Resource r = new Resource();
        //创建任务线程
        Input in = new Input(r);
        Output out = new Output(r);
        //开启线程
        in.start();
        out.start();

        //创建资源，在单线程中，必须顺序依次调用set和out方法，否则会造成单线程一直等待。
//        Resource r = new Resource();
//        r.set("刘备", "男");
//        r.set("刘备", "男");
//        r.out();
    }
}