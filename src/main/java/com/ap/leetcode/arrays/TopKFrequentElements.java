package com.ap.leetcode.arrays;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for(int num: nums) {
            int count = frequencyMap.getOrDefault(num, 0);
            frequencyMap.put(num, count + 1);
        }

        // Min Heap
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue)
        );

        for(Map.Entry<Integer, Integer> entry: frequencyMap.entrySet()) {
            minHeap.offer(entry);

            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[minHeap.size()];

        int index = minHeap.size() - 1;
        while(!minHeap.isEmpty()) {
            result[index--] = minHeap.poll().getKey();
        }
        return result;
    }
}
