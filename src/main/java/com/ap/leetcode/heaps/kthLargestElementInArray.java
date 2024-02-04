package com.ap.leetcode.heaps;

import java.util.PriorityQueue;

/**
 * LC: https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 */
public class kthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num: nums) {
            minHeap.add(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
