package com.goura.leetcode;

import java.util.Arrays;

/**
 * 238. Product of Array Except Self
 * 
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Example:
 * 		Input:  [1,2,3,4]
 * 		Output: [24,12,8,6]
 * 
 * Note: Please solve it without division and in O(n).
 * 
 * @author Gourahari Das
 * 12:45 - 1:05
 *
 */
public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		assert Arrays.equals(product(new int[] {1, 2, 3, 4}),new int[] {24, 12, 8, 6}) : "Fail";
		assert Arrays.equals(product(new int[] {4, 5, 3, 2}), new int[] {30, 24, 40, 60}) : "Fail";
		assert Arrays.equals(product(new int[] {}), new int[] {}) : "Fail";
		assert Arrays.equals(product(new int[] {-2, 3, -4, 6}), new int[] {-72, 48, -36, 24}) : "Fail";
	}

    public static int[] product(int[] nums) {
    	int[] result = new int[nums.length];
    	if (0 == nums.length) {
    		return result;
    	}

    	int p = 1;
    	result[0] = p;
    	for (int i = 1; i < nums.length; i++) {
    		p *= nums[i- 1];
			result[i] = p;
		}

    	p = 1;
    	for (int i = nums.length - 1; i >= 0; i--) {
			result[i] *= p;
    		p *= nums[i];
		}
    	return result;
    }
}
