package com.ap.leetcode.twopointer;

/**
 * LC: https://leetcode.com/problems/container-with-most-water/description/
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(area, maxArea);
            if(height[left] < height[right]) {
                left++;
            } else {
                right --;
            }
        }
        return maxArea;
    }
}
