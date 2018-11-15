package com.goura.leetcode;

/**
 *
 * 3. Longest Substring Without Repeating Characters
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * @author BGH32320
 *
 */
public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		assert lengthOfLongestSubstring("abcabcbb") == 3 : "Fail";
		assert lengthOfLongestSubstring("bbbbb") == 1 : "Fail";
		assert lengthOfLongestSubstring(" ") == 1 : "Fail";
		assert lengthOfLongestSubstring("pwwkew") == 3 : "Fail";
		assert lengthOfLongestSubstring("dvdf") == 3 : "Fail";
	}

	public static int lengthOfLongestSubstring(String s) {
		char[] chars = s.toCharArray();
		String result = "";
		int len = 0;
		for (int i = 0; i < chars.length; i++) {
			int index = result.indexOf(chars[i]);
			if (-1 == index) {
				result += chars[i];
			} else {
				if (len < result.length()) {
					len = result.length();
				}
				if (result.length() - index == 1) {
					result = String.valueOf(chars[i]);
				} else {
					//System.out.println(result + " / " + chars[i] + " = " + result.substring(index + 1, result.length()) + chars[i]);
					result = result.substring(index + 1, result.length()) + chars[i];
				}
			}
		}
		if (len < result.length()) {
			len = result.length();
		}
		return len;
	}
}
