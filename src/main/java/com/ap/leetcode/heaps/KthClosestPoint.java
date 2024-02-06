package com.ap.leetcode.heaps;

import java.util.PriorityQueue;

/**
 * LC: https://leetcode.com/problems/k-closest-points-to-origin/description/
 */
public class KthClosestPoint {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((n1, n2) ->
                Integer.compare(
                        dist(n2), dist(n1)
                )
        );

        for(int[] point: points) {
            queue.offer(point);
            if(queue.size() > k) {
                queue.poll();
            }
        }

        int[][] result = new int[queue.size()][2];

        int index = 0;
        while(!queue.isEmpty()) {
            int[] res = queue.poll();
            result[index][0] = res[0];
            result[index++][1] = res[1];
        }

        return result;
    }

    private int dist(int[] n) {
        return n[0]*n[0] + n[1]*n[1];
    }
}
