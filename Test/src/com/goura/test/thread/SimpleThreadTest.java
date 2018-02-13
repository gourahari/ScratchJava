package com.goura.test.thread;

import java.util.concurrent.TimeUnit;

public class SimpleThreadTest {

    public static void main(String[] args) {
        System.out.println("Main starts!");
        new Thread(new MyTask("first")).start();
        new Thread(new MyTask("second")).start();
        System.out.println("Main ends!");
    }

}

class MyTask implements Runnable {
    final String name;
    public MyTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + " thread printing: " + i);
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
}
