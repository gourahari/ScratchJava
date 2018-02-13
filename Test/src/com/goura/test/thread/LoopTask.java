package com.goura.test.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

class LoopTask implements Callable<Integer> {
    private final String name;
    private static final Random random = new Random(System.currentTimeMillis());

    public LoopTask(String name) {
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("###### Task[" + name + "] started.");
        for (int i = 0; i < 5; i++) {
            System.out.println(name + " thread printing: " + i);
            try {
                TimeUnit.MILLISECONDS.sleep(random(100, 2000));
            } catch (InterruptedException e) {
            }
        }
        System.out.println("****** Task[" + name + "] ended.");
        return 10;
    }

    public static int random(int min, int max) {
        return random.nextInt(max + 1 - min) + min;
    }
}
