package com.ap.leetcode.arrays;

import java.util.Arrays;

/**
 * LC: https://leetcode.com/problems/longest-consecutive-sequence/description/
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int longest = 0;
        int current = 1;
        for(int i = 1; i < nums.length; i++) {

            if(nums[i] != nums[i - 1]) {
                if(Math.abs(nums[i] - nums[i - 1]) == 1) {
                    current++;
                } else {
                    longest = Math.max(longest, current);
                    current = 1;
                }
            }
        }
        return Math.max(longest, current);
    }

}
