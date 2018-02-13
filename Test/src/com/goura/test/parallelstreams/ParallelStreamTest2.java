package com.goura.test.parallelstreams;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class ParallelStreamTest2 {

	public static void main(String[] args) throws Exception {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

		Stream<Integer> stream =
		  list.stream()
			.parallel()
			.map(ParallelStreamTest2::calculate);
		process(stream);
	}

	private static int calculate(int i) {
		System.out.println(Thread.currentThread());
		return i * 2;
	}

	private static void process(Stream<Integer> stream) throws Exception {
		ForkJoinPool pool = new ForkJoinPool(10);

		pool.submit(() -> stream.forEach(e -> {}));

		pool.shutdown();
		pool.awaitTermination(10, TimeUnit.SECONDS);
		//stream.forEach(System.out::println);
	}

	private static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
		}
	}
}
