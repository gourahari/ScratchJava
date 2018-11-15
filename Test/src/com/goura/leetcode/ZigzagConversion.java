package com.goura.leetcode;

/**
 * 6. ZigZag Conversion
 * 
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
 * 
 * 
 * @author BGH32320
 *
 */
public class ZigzagConversion {

	public static void main(String[] args) {
		assert convert("AB", 1).equals("AB") : "Fail";
		assert convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR") : "Fail";
		assert convert("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI") : "Fail";
	}

	private static String convert(String s, int numRows) {
		int[] index = new int[numRows];
		char[][] a = new char[numRows][s.length()];

		int line = 0, shift = 1;
		for (int i = 0; i < s.length(); i++) {
			a[line][index[line]++] = s.charAt(i);
			if (numRows - 1 != 0) {
				if ((shift < 0 && line == 0) || (shift > 0 && line == numRows - 1)) {
					shift = shift * -1;
				}
				line += shift;
			}
		}

		String t = "";
		for (int i = 0; i < numRows; i++) {
			t += new String(a[i]).trim();
		}
		return t;
	}
}
