package com.ap.leetcode.graphs;

/**
 * LC: https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    numIslands++;
                    dfsHelper(grid, i, j);
                }
            }
        }
        return numIslands;
    }

    private void dfsHelper(char[][] grid, int i, int j) {
        if(i < 0 || j < 0
            || i >= grid.length || j >= grid[0].length
            || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        dfsHelper(grid, i + 1, j);
        dfsHelper(grid, i - 1, j);
        dfsHelper(grid, i, j + 1);
        dfsHelper(grid, i, j - 1);
    }
}
