package com.ap.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LC: https://leetcode.com/problems/subsets/description/
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        subsetHelper(nums, new LinkedList<Integer>(), result, 0);

        return result;
    }

    private void subsetHelper(int[] nums, LinkedList<Integer> slate, List<List<Integer>> result, int index) {
        // base case
        if(index == nums.length) {
            result.add(new ArrayList<Integer>(slate));
            return;
        }

        // recursion

        // exclude the element
        subsetHelper(nums, slate, result, index + 1);

        // include the element
        slate.add(nums[index]);
        subsetHelper(nums, slate, result, index + 1);
        slate.removeLast();
    }
}
