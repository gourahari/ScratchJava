package com.goura.leetcode;

/**
 * Asked in AMAZON.
 * 387. First Unique Character in a String
 * 
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * 
 * s = "leetcode"
 * return 0.
 * 
 * s = "loveleetcode",
 * return 2.
 * 
 * @author Gourahari Das
 *
 */
public class FirstUniqueCharacterInString {

	public static void main(String[] args) {
		assert firstUniqChar("leetcode") == 0 : "Fail";
		assert firstUniqChar("loveleetcode") == 2 : "Fail";
	}

    public static int firstUniqChar(String s) {
    	int[] alpha = new int[26];
    	for (char c : s.toCharArray()) {
			alpha[c - 'a']++;
		}

    	int index = -1;
    	for (int i = 0; i < s.length(); i++) {
			if (1 == alpha[s.charAt(i) - 'a']) {
				index = i;
				break;
			}
		}
    	return index;
    }
}
