package com.goura.leetcode;

import java.util.Arrays;

/**
 * 985. Sum of Even Numbers After Queries
 * 
 * @author Gourahari Das
 *
 */
public class SumOfEvenNumbersAfterQueries {

	public static void main(String[] args) {
		int[] result = sumEvenAfterQueries(new int[] {1,2,3,4}, new int[][] {{1,0}, {-3,1}, {-4,0}, {2,3}});
		System.out.println(Arrays.toString(result));
	}

    public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] result = new int[queries.length];
        int sum = 0;

        for (int i : A) {
			if (i %2 == 0) {
				sum += i;
			}
		}

        for (int i = 0; i < queries.length; i++) {
        	int[] q = queries[i];
			if (A[q[1]] % 2 == 0) {
				sum -= A[q[1]];
			}
			A[q[1]] += q[0];
			if (A[q[1]] % 2 == 0) {
				sum += A[q[1]];
			}
			result[i] = sum;
		}
        return result;
    }

}
