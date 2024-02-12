package com.ap.leetcode.arrays;

/**
 * https://leetcode.com/problems/product-of-array-except-self/description/
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int [] result = new int[nums.length];

        int prefix = 1;
        for(int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        int postFix = 1;
        for(int j = nums.length - 1; j >= 0; j--) {
            result[j] *= postFix;
            postFix *= nums[j];
        }

        return result;
    }
}
