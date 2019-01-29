package com.goura.leetcode;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * 	   Open brackets must be closed by the same type of brackets.
 * 	   Open brackets must be closed in the correct order.
 *     Note that an empty string is also considered valid.
 * 
 * @author Gourahari Das
 *
 */
public class ValidParentheses {

	public static void main(String[] args) {
		assert validParentheses("()") == true : "Fail";
		assert validParentheses("(){}[]") == true : "Fail";
		assert validParentheses("(]") == false : "Fail";
		assert validParentheses("([)]") == false : "Fail";
		assert validParentheses("({})") == true : "Fail";
		assert validParentheses("9({})9") == false : "Fail";
		assert validParentheses("") == true : "Fail";
		assert validParentheses("]") == false : "Fail";
	}

    public static boolean validParentheses(String s) {
    	Stack<Integer> stack = new Stack<>();

    	for (char c : s.toCharArray()) {
    		if (c == '(' || c == '[' || c == '{') {
    			stack.push((int) c);
    		} else {
    			if (stack.isEmpty()) {
    				stack.push((int) c);
    			} else {
    				if (c == ')' && stack.peek() == '(') {
    					stack.pop();
    				} else if (c == ']' && stack.peek() == '[') {
    					stack.pop();
    				} else if (c == '}' && stack.peek() == '{') {
    					stack.pop();
    				} else {
    					stack.push((int) c);
    				}
    			}
    		}
		}
        return stack.isEmpty();
    }
}
