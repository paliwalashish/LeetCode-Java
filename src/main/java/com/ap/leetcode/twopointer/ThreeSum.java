package com.ap.leetcode.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if(i == 0 || nums[i - 1] != nums[i]) {
                twoSum(nums, i, result);
            }
        }
        return result;
    }

    private void twoSum(int[] nums, int startIndex, List<List<Integer>> result) {
        int low = startIndex + 1;
        int high = nums.length - 1;

        while(low < high) {
            int sum = nums[low] + nums[high] + nums[startIndex];
            if(sum < 0) {
                low++;
            } else if(sum > 0) {
                high--;
            } else {
                result.add(Arrays.asList(nums[startIndex], nums[low++], nums[high--]));
                while(low < high && nums[low] == nums[low - 1]) {
                    low++;
                }
            }
        }
    }
}
