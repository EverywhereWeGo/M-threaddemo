package com.bfd.bookdemo.t4_threadsafe;

class LoginServlet {
    private static String usernameRef;
    private static String passwordRef;

    //    public static void doPost(String username, String password) {
    synchronized public static void doPost(String username, String password) {
        try {
            usernameRef = username;
            if (username.equals("a")) {
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        passwordRef = password;
        System.out.println("username:" + usernameRef + " passwoed:" + password);
    }
}


class Alogin extends Thread {
    public void run() {
        LoginServlet.doPost("a", "aa");
    }
}

class Blogin extends Thread {
    public void run() {
        LoginServlet.doPost("b", "bb");
    }
}


public class Run {
    public static void main(String[] args) {
        Alogin a = new Alogin();
        a.start();
        Blogin b = new Blogin();
        b.start();

    }

}