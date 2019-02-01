package com.goura.leetcode;

/**
 * 42. Trapping Rain Water
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * Example:
 * 		Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 *		Output: 6
 * 
 * @author Gourahari Das
 *
 */
public class TrappingRainWater {

	public static void main(String[] args) {
		assert trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}) == 6 : "Fail";
		assert trap(new int[] { 2, 0, 2}) == 2 : "Fail";
	}

    public static int trap(int[] height) {
    	int result = 0, left = 0, right = 0, temp = 0;;
    	for (int i = 0; i < height.length; i++) {
    		left = 0;
    		right = 0;
        	for (int j = i-1; j >= 0; j--) {
        		if (height[j] > left)
        			left = height[j];
        	}

        	if (left > 0) {
	        	for (int j = i+1; j < height.length; j++) {
	        		if (height[j] > right)
	        			right = height[j];
	        	}
    		}

        	temp = (left < right? left : right) - height[i];
        	if (temp > 0) {
        		result += temp;
        	}
    	}
        return result;
    }
}
