package com.ap.leetcode.tries;

/**
 * Implement a Trie
 *
 * LC: https://leetcode.com/problems/implement-trie-prefix-tree
 */
public class Trie {

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(char w: word.toCharArray()) {
            node = node.add(w);
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for(char ch: word.toCharArray()) {
            node = node.get(ch);
            if(node == null) return false;
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char ch: prefix.toCharArray()) {
            node = node.get(ch);
            if(node == null) return false;
        }
        return true;
    }
}
