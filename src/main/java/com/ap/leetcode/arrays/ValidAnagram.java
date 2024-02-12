package com.ap.leetcode.arrays;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int[] anagramArray = new int[26];

        for(int i = 0; i < s.length(); i++) {
            anagramArray[s.charAt(i) - 'a']++;
            anagramArray[t.charAt(i) - 'a']--;
        }

        for(int num: anagramArray ) {
            if(num != 0) {
                return false;
            }
        }
        return true;
    }
}
