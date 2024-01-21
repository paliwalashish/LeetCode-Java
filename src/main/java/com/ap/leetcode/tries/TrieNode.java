package com.ap.leetcode.tries;

/**
 * A simple TrieNode class
 * does not use Generics
 *
 * This class is specific to word use case with only lower case
 */
public class TrieNode {
    char val;
    boolean isWord;

    TrieNode() {}

    TrieNode(char ch) {
        this.val = ch;
    }

    TrieNode[] children = new TrieNode[26];

    TrieNode add(char ch) {
        if(children[ch - 'a'] == null) {
            TrieNode n = new TrieNode(ch);
            children[ch - 'a'] = n;
        }
        return children[ch - 'a'];
    }

    TrieNode get(char ch) {
        return children[ch - 'a'];
    }
}
