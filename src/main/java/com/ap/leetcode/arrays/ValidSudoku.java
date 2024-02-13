package com.ap.leetcode.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-sudoku/description/
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> positionMap = new HashMap<>();
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> columnMap = new HashMap<>();

        for(int i = 0; i <= 8; i++) {
            positionMap.put(i, new HashSet<>());
            rowMap.put(i, new HashSet<>());
            columnMap.put(i, new HashSet<>());
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.') {
                    continue;
                }

                // get box
                int box = getBox(i, j);
                char num = board[i][j];
                if(positionMap.get(box).contains(num)) {
                    return false;
                }
                positionMap.get(box).add(num);

                // check row
                if(rowMap.get(i).contains(num)) {
                    return false;
                }
                rowMap.get(i).add(num);

                // check column
                if(columnMap.get(j).contains(num)) {
                    return false;
                }
                columnMap.get(j).add(num);
            }
        }
        return true;
    }

    private int getBox(int x, int y) {
        return (x / 3)*3 + (y / 3);
    }
}
