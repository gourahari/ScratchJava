package com.goura.test.interview;

public class FindNegativeNumbersCountInTwoDimensionArray {

	public static void main(String[] args) {
		int[][] data = new int[][] {
			{-10, -7, -3, -1, 3, 9, 10},
			{-3, -2, -1, 5, 6, 8, 9},
			{-7, -6, -5, -4, -2, 0, 3}
		};

		int count = 0;
		int n = 7;

		for (int i = 0; i < data.length; i++) {
			for (int j = n - 1; j >= 0; j--) {
				if (data[i][j] < 0) {
					count += (j + 1);
					break;
				}
			}
			
		}
		System.out.println("Count: " + count);
		count = 0;

		for (int i = 0, j = n - 1; j >= 0 && i < data.length;) {
			if (data[i][j] < 0) {
				count += (j + 1);
				i++;
			} else {
				j--;
			}
		}
		System.out.println("Count: " + count);
	}
}
