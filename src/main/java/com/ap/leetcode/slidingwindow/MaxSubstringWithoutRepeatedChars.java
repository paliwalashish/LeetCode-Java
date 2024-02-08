package com.ap.leetcode.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class MaxSubstringWithoutRepeatedChars {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        char[] sArray = s.toCharArray();
        Set<Character> charSet = new HashSet<>();
        while(right < sArray.length) {

            // shrink the window
            while (charSet.contains(sArray[right])) {
                charSet.remove(sArray[left++]);
            }

            //expand the window
            charSet.add(sArray[right]);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

       return maxLength;
    }
}
