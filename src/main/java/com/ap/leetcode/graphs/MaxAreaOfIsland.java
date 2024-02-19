package com.ap.leetcode.graphs;

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    int area = dfsHelper(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }

    private int dfsHelper(int[][] grid, int x, int y) {
        // base case
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length
            || grid[x][y] == 0) {
            return 0;
        }

        grid[x][y] = 0;

        int left = dfsHelper(grid, x - 1, y);
        int right = dfsHelper(grid, x + 1, y);
        int top = dfsHelper(grid, x, y - 1);
        int bottom = dfsHelper(grid, x, y + 1);

        return left + right + top + bottom + 1;
    }
}
