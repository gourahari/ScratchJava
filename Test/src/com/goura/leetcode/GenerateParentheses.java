package com.goura.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * 
 * @author Gourahari Das
 *
 */
public class GenerateParentheses {

    public static void main(String[] args) {
    	generateParenthesis(3);
	}

    public static List<String> generateParenthesis(int n) {
    	List<String> list = new ArrayList<>();
    	int right = n, left = n;
    	generate(list, "", left, right);
    	System.out.println(list);
    	return list;
    }

    public static void generate(List<String> list, String sequence, int left, int right) {
    	if (left == 0) {
    		while (right > 0) {
    			sequence += ')';
    			right--;
    		}
    		list.add(sequence);
    		return;
    	}

    	if (left == right) {
    		generate(list, sequence + '(', left-1, right);
    	} else if (left < right) {
    		generate(list, sequence + '(', left-1, right);
    		generate(list, sequence + ')', left, right-1);
    	}
    }
}
