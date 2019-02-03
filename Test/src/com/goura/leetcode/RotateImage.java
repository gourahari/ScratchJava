package com.goura.leetcode;

import java.util.Arrays;

public class RotateImage {

	public static void main(String[] args) {
		int weight = 5;
		int[][] matrix = prepare2DArray(weight);
        rotate(matrix);
        System.out.println("============================================");
        print2D(matrix);
        System.out.println("============================================");
		assert Arrays.deepEquals(matrix, prepare2DArrayRotated(weight)) : "fail";
	}

    public static void rotate(int[][] matrix) {
    	int start = 0;
    	int end = matrix.length - 1;

		while (start < end) {
			for (int y = 0; y < end-start; y++) {
				swap(matrix, start, start + y, start + y, end);
				swap(matrix, start, start + y, end, end-y);
				swap(matrix, start, start + y, end - y, start);
			}
			start++;
			end--;
		}
    }

    private static void swap(int[][] matrix, int i, int j, int m, int n) {
    	matrix[i][j] = matrix[i][j] + matrix[m][n];
    	matrix[m][n] = matrix[i][j] - matrix[m][n];
        matrix[i][j] = matrix[i][j] - matrix[m][n];
	}

    private static void print2D(int matrix[][]) {
		for (int[] row : matrix)
			System.out.println(Arrays.toString(row));
	}

	private static int[][] prepare2DArray(int n) {
		int start = 11;
		int[][] result = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result[i][j] = start++;
			}
		}
    	print2D(result);
		return result;
	}

	private static int[][] prepare2DArrayRotated(int n) {
		int start = 11;
		int[][] result = new int[n][n];
		for (int j = n-1; j >= 0; j--) {
			for (int i = 0; i < n; i++) {
				result[i][j] = start++;
			}
		}
    	print2D(result);
		return result;
	}
}
