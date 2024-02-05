package com.ap.leetcode.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * LC: https://leetcode.com/problems/last-stone-weight/description/
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone: stones) {
            heap.add(stone);
        }

        while(heap.size() > 1) {
            int x = heap.poll();
            int y = heap.poll();

            if(x != y) {
                heap.add(Math.abs(x - y));
            }
        }
        return heap.isEmpty() ? 0 : heap.poll();
    }
}
