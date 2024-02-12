package com.ap.leetcode.arrays;

import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams/
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for(String s: strs) {
            char[] sArray = s.toCharArray();
            Arrays.sort(sArray);
            String anagramString = new String(sArray);
            List<String> anagramList = anagramMap.getOrDefault(anagramString, new ArrayList<String>());
            anagramList.add(s);
            anagramMap.put(anagramString, anagramList);
        }

        return new ArrayList(anagramMap.values());
    }
}
