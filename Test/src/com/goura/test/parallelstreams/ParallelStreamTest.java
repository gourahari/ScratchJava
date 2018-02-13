package com.goura.test.parallelstreams;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamTest {

	public static void main(String[] args) throws Exception {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		System.out.println(1 +
		list.stream()
			.parallel()
			.map(ParallelStreamTest::calculate)
			.reduce(0, ParallelStreamTest::sum));
	}

	private static int sum(int a, int b) {
		int sum = a + b;
		System.out.printf("a: %s, b: %s, sum: %s, Thread: %s\n", a, b, sum, Thread.currentThread());
		return sum;
	}

	private static int calculate(int i) {
		return i * 2;
	}

	private static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
		}
	}
}
