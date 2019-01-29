package com.goura.leetcode;

import java.util.Arrays;

/**
 * Asked in Amazon
 * 344. Reverse String
 * 
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * 
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * 
 * You may assume all the characters consist of printable ascii characters.
 * 
 * @author Gourahari Das
 *
 */
public class ReverseString {

	public static void main(String[] args) {
		String[] strings = new String[] {"Gourahari", "Palace", "Gitanjali", "Hannah", "hello"};
		//String[] strings = new String[] {"hello"};
		
		for (String s : strings) {
			char[] chars = s.toCharArray();
			System.out.println("Input: " + Arrays.toString(chars));
			reverseString(chars);
			System.out.println("Output: " + Arrays.toString(chars));
			System.out.println("=========================================");
		}
	}

    public static void reverseString(char[] s) {
    	char temp;
        for (int i = 0; i < s.length/2; i++) {
			temp = s[i];
			s[i] = s[s.length - 1 -i];
			s[s.length - 1 -i] = temp;
		}
    }
}
