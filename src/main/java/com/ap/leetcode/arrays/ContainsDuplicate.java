package com.ap.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * LC: https://leetcode.com/problems/contains-duplicate/description/
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for(int num: nums) {
            if(numSet.contains(num)) {
                return true;
            }
            numSet.add(num);
        }

        return false;
    }
}
