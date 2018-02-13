package com.goura.test.parallelstreams;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {

	public static void main(String[] args) throws Exception {
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(CompletableFutureTest::generate);

		sleep(1000);
		future
			.thenApply(CompletableFutureTest::compute)
			.thenAccept(CompletableFutureTest::print);

		CompletableFuture<Integer> future1 = new CompletableFuture<>();

		sleep(1000);
		future1
			.thenApply(CompletableFutureTest::compute)
			.thenAccept(CompletableFutureTest::print);
		future1.complete(5);

		sleep(1000);
		//System.out.println(future.getNow(-1));
		//.thenAccept(e -> System.out.println("Next thing."));

		System.out.println("main done!");
	}

	private static int generate() {
		//System.out.println("Working... " + Thread.currentThread());
		return 2;
	}

	private static void print(int value) {
		System.out.println(value);
	}

	private static int compute(int value) {
		return value * 2;
	}

	private static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
		}
	}
}
