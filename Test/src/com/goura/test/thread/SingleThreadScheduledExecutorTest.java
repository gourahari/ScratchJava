package com.goura.test.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SingleThreadScheduledExecutorTest {

    public static void main(String[] args) throws Exception {
        System.out.println("Main starts!");

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        Future<Integer> future = service.schedule(new LoopTask("first"), 10, TimeUnit.SECONDS);
        service.schedule(new LoopTask("second"), 2, TimeUnit.SECONDS);
        service.submit(new LoopTask("third"));
        service.shutdown();
        System.out.println(future.get());

        System.out.println("Main ends!");
    }

}
