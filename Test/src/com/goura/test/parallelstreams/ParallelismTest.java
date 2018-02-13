package com.goura.test.parallelstreams;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ParallelismTest {

	private static final int MAX = 2_000;
	public static void main(String[] args) throws Exception {
		long t1 = System.currentTimeMillis();
		/*double result = IntStream.range(0, MAX)
				.parallel()
				.mapToDouble(ParallelismTest::compute)
				.sum();
		System.out.println("result: " + result);*/

		ForkJoinPool pool = new ForkJoinPool(15);

		pool.submit(() -> {
			double result = IntStream.range(0, MAX)
					.parallel()
					.mapToDouble(ParallelismTest::compute)
					.sum();

			System.out.println("result: " + result);
		});

		pool.shutdown();
		pool.awaitTermination(30, TimeUnit.SECONDS);

		System.out.printf("Time taken: %d ms.", (System.currentTimeMillis() - t1));
	}

	private static double compute(double number) {
		//System.out.println(Thread.currentThread());
		double result = 0;
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				result += Math.sqrt(i * j);
			}
		}
		return result;
	}
}
