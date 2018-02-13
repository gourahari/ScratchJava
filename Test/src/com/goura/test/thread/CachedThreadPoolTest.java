package com.goura.test.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CachedThreadPoolTest {

    public static void main(String[] args) throws Exception {
        System.out.println("Main starts!");

        ExecutorService service = Executors.newCachedThreadPool();
        Future<Integer> future1 = service.submit(new LoopTask("first"));
        service.submit(new LoopTask("second"));
        service.submit(new LoopTask("third"));
        Future<Integer> future4 = service.submit(new LoopTask("fourth"));
        service.shutdown();

        System.out.println("1: " + future1.get());
        System.out.println("4: " + future4.get());

        System.out.println("Main ends!");
        List<String> list = Arrays.asList(args);
        list.iterator();
    }
}
