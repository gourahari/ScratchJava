package com.goura.leetcode;

/**
 * 7. Reverse Integer
 * 
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * 
 * Input: 123 Output: 321 Example 2:
 * 
 * Input: -123 Output: -321 Example 3:
 * 
 * Input: 120 Output: 21
 * 
 * Assume we are dealing with an environment which could only store integers within the
 * 32-bit signed integer range: [-2^31,  2^31 - 1]. For the purpose of this problem,
 * assume that your function returns 0 when the reversed integer overflows.
 * 
 * 
 * @author BGH32320
 *
 */
public class Reverse32BitSignedInteger {

	public static void main(String[] args) {
		assert reverse(123) == 321 : "Fail";
		assert reverse(-123) == -321 : "Fail";
		assert reverse(1534236469) == 0 : "Fail";
	}

	private static int reverse(int x) {
		long result = 0;
		while (x != 0) {
			result += (x%10);
			if ((x = x/10) != 0) {
				result *= 10;
			}
		}
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			result = 0;
		}
		return (int) result;
	}
}
