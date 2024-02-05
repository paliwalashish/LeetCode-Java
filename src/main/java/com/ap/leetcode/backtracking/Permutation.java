package com.ap.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LC: https://leetcode.com/problems/permutations/description/
 */
public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new LinkedList<Integer>(), nums, 0);
        return result;
    }

    private void helper(List<List<Integer>> result, LinkedList<Integer> slate, int[] nums, int index) {
        // base case
        if(slate.size() == nums.length) {
            result.add(new ArrayList<>(slate));
            return;
        }

        // recursion case
        for(int i = index; i < nums.length; i++) {
            slate.add(nums[i]);
            swap(nums, index, i);
            helper(result, slate, nums, index + 1);
            slate.removeLast();
            swap(nums, index, i);
        }

    }

    private void swap(int[] nums, int idx1, int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }
}
