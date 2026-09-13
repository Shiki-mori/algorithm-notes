package com.phrolova.algorithm.leetcode.p1657_determine_if_two_strings_are_close;

import java.util.HashMap;
import java.util.Map;

public class DetermineIfTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {

        int n = word1.length();
        if (n != word2.length()) {
            return false;
        }

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0) + 1);
            map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0) + 1);
        }

        // 必须把values转为HashMap后比较
        Map<Integer, Integer> v1 = new HashMap<>();
        Map<Integer, Integer> v2 = new HashMap<>();

        for (int value1 : map1.values()) {
            v1.put(value1, v1.getOrDefault(value1, 0) + 1);
        }
        for (int value2 : map2.values()) {
            v2.put(value2, v2.getOrDefault(value2, 0) + 1);
        }
        if (map1.keySet().equals(map2.keySet()) && v1.equals(v2))
            return true;
        return false;
    }

    // ----------------------------
    
    public boolean closeStringsOfficial(String word1, String word2) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (char c : word1.toCharArray()) {
            count1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            count2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count1[i] > 0 && count2[i] == 0 || count1[i] == 0 && count2[i] > 0) {
                return false;
            }
        }
        Arrays.sort(count1);
        Arrays.sort(count2);

        return Arrays.equals(count1, count2);
        return count1.equals(count2);
    }

    public static void main(String[] args) {
    }
}
