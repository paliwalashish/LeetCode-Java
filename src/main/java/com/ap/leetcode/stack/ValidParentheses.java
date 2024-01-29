package com.ap.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> lookupMap = new HashMap<>();
        lookupMap.put(')', '(');
        lookupMap.put(']', '[');
        lookupMap.put('}', '{');


        for(char ch: s.toCharArray()) {
            if(lookupMap.containsKey(ch)) {
                if(stack.isEmpty() || stack.peek() != lookupMap.get(ch)) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
