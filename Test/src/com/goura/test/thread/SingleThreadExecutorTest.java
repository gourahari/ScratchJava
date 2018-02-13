package com.goura.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingleThreadExecutorTest {

    public static void main(String[] args) throws Exception {
        System.out.println("Main starts!");

        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> future = service.submit(new LoopTask("first"));
        service.submit(new LoopTask("second"));
        service.submit(new LoopTask("third"));
        service.shutdown();
        System.out.println(future.get());

        System.out.println("Main ends!");
    }

}
