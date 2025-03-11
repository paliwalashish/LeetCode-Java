package com.ap.leetcode.simple;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/check-if-the-sentence-is-pangram/
 */
public class Panagram {
    public boolean checkIfPangram(String sentence) {
        int[] chars = new int[26];

        for(char ch: sentence.toCharArray()) {
            chars[ch - 'a']++;
        }
        for(int i: chars) {
            if(i == 0) return false;
        }

        return true;
    }
}
