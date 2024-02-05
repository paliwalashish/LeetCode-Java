package com.ap.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/description/
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        helper(candidates, target, 0, new LinkedList<Integer>(), result);

        return result;
    }

    private void helper(int[] candidates, int target, int index,
                        LinkedList<Integer> slate, List<List<Integer>> result) {
        // base case
        if(target == 0) {
            result.add(new ArrayList<Integer>(slate));
            return;
        }

        if(target < 0 || index == candidates.length) {
            return;
        }

        // recursion case
        for(int i = index; i < candidates.length; i++) {
            slate.add(candidates[i]);
            helper(candidates, target - candidates[index], i,
                    slate, result);
            slate.removeLast();
        }

    }
}
