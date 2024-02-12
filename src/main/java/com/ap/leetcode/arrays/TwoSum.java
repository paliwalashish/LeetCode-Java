package com.ap.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * LC: https://leetcode.com/problems/two-sum/description/
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> numMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int compNum = target - nums[i];

            if(numMap.containsKey(compNum)) {
                result[0] = i;
                result[1] = numMap.get(compNum);
                return result;
            }
            numMap.put(nums[i], i);
        }

        return result;
    }
}
