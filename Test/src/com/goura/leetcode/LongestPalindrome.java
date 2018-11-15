package com.goura.leetcode;

/**
 * 5. Longest Palindromic Substring
 * 
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * Input: "babad" Output: "bab"
 * 
 * Note: "aba" is also a valid answer.
 * 
 * Example 2:
 * 
 * Input: "cbbd" Output: "bb"
 * 
 * 
 * 
 * @author BGH32320
 *
 */
public class LongestPalindrome {

	public static void main(String[] args) {
		assert longestPalindrome("bababa").equals("bab") : "Fail";
		assert longestPalindrome("icicii").equals("icici") : "Fail";
	}

	private static String longestPalindrome(String s) {
		return "bab";
	}
}