package com.goura.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolTest {

    public static void main(String[] args) {
        System.out.println("Main starts!");

        ExecutorService service = Executors.newFixedThreadPool(3);
        service.submit(new LoopTask("first"));
        service.submit(new LoopTask("second"));
        service.submit(new LoopTask("third"));
        service.submit(new LoopTask("fourth"));
        service.shutdown();

        System.out.println("Main ends!");
    }

}
