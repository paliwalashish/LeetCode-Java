package com.ap.leetcode.heaps;

import java.util.PriorityQueue;

/**
 * LC: https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */
public class KthLargestElementInStream {

    private int maxSize = -1;
    private PriorityQueue<Integer> minHeap;


    public KthLargestElementInStream(int maxSize, int[] nums) {
        this.maxSize = maxSize;
        for(int num: nums) {
            add(num);
        }
    }

    public int add(int val) {
        minHeap.add(val);

        if(minHeap.size() > maxSize) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
