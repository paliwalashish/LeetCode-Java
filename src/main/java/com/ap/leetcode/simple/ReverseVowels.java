package com.ap.leetcode.simple;

import java.util.Set;

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 */
public class ReverseVowels {
    public String reverseVowels(String s) {
        Set<Character> vowelSet = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        char[] input = s.toCharArray();

        int low = 0;
        int high = input.length - 1;

        while(low < high) {
            while(low < high && !vowelSet.contains(input[low])) {
                low++;
            }

            while(low < high && !vowelSet.contains(input[high])) {
                high--;
            }

            char tmp = input[low];
            input[low] = input[high];
            input[high] = tmp;
            low++;
            high--;
        }

        return new String(input);
    }

    public static void main(String[] args) {
        ReverseVowels reverseVowels = new ReverseVowels();
        System.out.println(reverseVowels.reverseVowels("leetcode"));
    }
}
