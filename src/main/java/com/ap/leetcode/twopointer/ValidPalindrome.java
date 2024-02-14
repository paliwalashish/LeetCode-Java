package com.ap.leetcode.twopointer;

/**
 * LC: https://leetcode.com/problems/valid-palindrome/description/
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        char[] sArray = s.toCharArray();

        int left = 0;
        int right = sArray.length - 1;

        while(left <= right) {
            if(!Character.isLetterOrDigit(sArray[left])) {
                left++;
                continue;
            }

            if(!Character.isLetterOrDigit(sArray[right])) {
                right--;
                continue;
            }

            if(Character.toLowerCase(sArray[left]) != Character.toLowerCase(sArray[right])) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();

        System.out.println(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(validPalindrome.isPalindrome("race a car"));
    }
}
