package com.ap.leetcode.tries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Test cases from leetcode
class TrieNodeTest {

    @Test
    public void testTrie() {
        Trie trie = new Trie();
        trie.insert("apple");
        assertTrue(trie.search("apple"));   // return True
        assertFalse(trie.search("app"));     // return False
        assertTrue(trie.startsWith("app")); // return True
        trie.insert("app");
        assertTrue(trie.search("app"));     // return True
    }

}