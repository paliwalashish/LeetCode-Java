package com.ap.leetcode.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * LC: https://leetcode.com/problems/find-median-from-data-stream/description/
 */
public class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap = new PriorityQueue<>();
    }


    public void addNum(int num) {
        if(minHeap.isEmpty() || num < minHeap.peek()) {
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }
        balanceHeaps();
    }

    private void balanceHeaps() {
        if(minHeap.size() - maxHeap.size() > 1) {
            maxHeap.offer(minHeap.poll());
        } else if(maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if(minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else if(maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }

}
