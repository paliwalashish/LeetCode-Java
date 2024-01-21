package com.ap.leetcode.backtracking;

/**
 * LC: https://leetcode.com/problems/word-search/description/
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfsHelper(board, word.toCharArray(), i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsHelper(char[][] board, char[] word, int row, int col, int wordPosition) {
        // base case
        if(wordPosition == word.length) {
            return true;
        }

        // check in Range
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }

        // recursive case

        // preserve the word
        char ch = board[row][col];
        if (word[wordPosition] != ch) {
            return false;
        }

        // mark it with diff chasr to avoid infinite recursion
        board[row][col] = '#';
        boolean result = dfsHelper(board, word, row + 1, col, wordPosition + 1)
                || dfsHelper(board, word, row - 1, col, wordPosition + 1)
                || dfsHelper(board, word, row, col + 1, wordPosition + 1)
                || dfsHelper(board, word, row, col - 1, wordPosition + 1);

        // reset the word
        board[row][col] = ch;
        return result;
    }
}
