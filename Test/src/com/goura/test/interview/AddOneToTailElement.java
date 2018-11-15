package com.goura.test.interview;

import java.util.Arrays;

public class AddOneToTailElement {

	public static void main(String[] args) {
		int[] array = new int[] {9, 0, 9, 0, 9};

		int[] new_array = addOne(array);

		System.out.println("Input array: " + Arrays.toString(array));
		System.out.println("Output array: " + Arrays.toString(new_array));
	}

	private static int[] addOne(int[] data) {
		int carry = 1;
		int[] new_array = new int[data.length];
		Arrays.fill(new_array, 0);

		for (int i = data.length - 1; i >= 0; i--) {
			int sum = data[i] + carry;
			carry = (sum == 10)? 1 : 0;
			new_array[i] = sum % 10;
		}
		if (carry == 1) {
			new_array = new int[data.length + 1];
			Arrays.fill(new_array, 0);
			new_array[0] = 1;
		}
		return new_array;
	}

}
