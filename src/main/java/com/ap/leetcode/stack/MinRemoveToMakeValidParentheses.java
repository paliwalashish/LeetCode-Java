package com.ap.leetcode.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * LC: https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */
public class MinRemoveToMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> indexToRemove = new HashSet<>();

        char[] sArray = s.toCharArray();

        for(int i = 0; i < sArray.length; i++) {
            if(sArray[i] == '(') {
                stack.push(i);
            } else if(sArray[i] == ')') {
                if(stack.isEmpty()) {
                    indexToRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        while(!stack.isEmpty()) {
            indexToRemove.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < sArray.length; i++) {
            if(!indexToRemove.contains(i)) {
                sb.append(sArray[i]);
            }
        }
        return sb.toString();
    }
}
