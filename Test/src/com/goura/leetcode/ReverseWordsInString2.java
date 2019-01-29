package com.goura.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * Asked in Amazon
 * 186. Reverse Words in a String II
 * 
 * Example:
 * 	Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * 	Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 * 
 * Note:
 * 	A word is defined as a sequence of non-space characters.
 * 	The input string does not contain leading or trailing spaces.
 * 	The words are always separated by a single space.
 * 
 * Follow up: Could you do it in-place without allocating extra space?
 * 
 * @author Gourahari Das
 *
 */
public class ReverseWordsInString2 {

	public static void main(String[] args) {
		String[] strings = new String[] {"Why are you going to school"};
		
		for (String s : strings) {
			char[] chars = s.toCharArray();
			System.out.println("Input: " + Arrays.toString(chars));
			reverseWordsInString(chars);
			System.out.println("Output: " + Arrays.toString(chars));
			System.out.println("=========================================");
		}
	}

    public static void reverseWordsInString(char[] str) {
    	// Reverse the whole sentence.
    	Stack<Integer> spaces = new Stack<>();
        spaces.push(str.length);
        for (int i = 0; i < str.length; i++) {
        	if (str[i] == ' ') {
        		spaces.push(str.length - 1 - i);
        	}
        }

        reverse(str, 0, str.length);
        int start = 0;

        while (!spaces.isEmpty()) {
        	int index = spaces.pop();
        	reverse(str, start, index);
            start = index + 1;
		}
    }

    public static void reverse(char[] s, int start, int end) {
        char temp;
        for (int i = start; i < (start+end)/2; i++) {
			temp = s[i];
			s[i] = s[start + end - 1 - i];
			s[start + end - 1 - i] = temp;
		}
    }
}
