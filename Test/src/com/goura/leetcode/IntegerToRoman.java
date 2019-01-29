package com.goura.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author Gourahari Das
 *
 */
public class IntegerToRoman {

	private static int counter = 0;
	private static final Map<Integer, String> map = new LinkedHashMap<Integer, String>() {{
	    put(1000, "M");
	    put(900, "CM");
	    put(500, "D");
	    put(400, "CD");
	    put(100, "C");
	    put(90, "XC");
	    put(50, "L");
	    put(40, "XL");
	    put(10, "X");
	    put(9, "IX");
	    put(5, "V");
	    put(4, "IV");
	    put(1, "I");
	}};

	public static void main(String[] args) {
		assert "III".equals(intToRoman(3))  : "Fail";
		assert "IV".equals(intToRoman(4)) : "Fail";
		assert "IX".equals(intToRoman(9)) : "Fail";
		assert "X".equals(intToRoman(10)) : "Fail";
		assert "LIX".equals(intToRoman(59)) : "Fail";
		assert "LVIII".equals(intToRoman(58)) : "Fail";
		assert "MCMXCIV".equals(intToRoman(1994)) : "Fail";
    	System.out.println("Total iterations: " + counter);
	}

    private static String intToRoman(int num) {
    	String result = "";
    	while (num > 0) {
    		for (Map.Entry<Integer, String> e : map.entrySet()) {
    			counter++;
    	    	if (e.getKey() <= num) {
					result += e.getValue();
					num -= e.getKey();
					break;
				}
			}
    	}
        return result;
    }
}
