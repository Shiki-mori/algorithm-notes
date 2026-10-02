package com.phrolova.algorithm.hot100.p0049_group_anagrams;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());
    }

    // -------------------------------------------
    // 计数

    public List<List<String>> groupAnagramsCounts(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {

            int[] counts = new int[26];

            int length = str.length();

            for (int i = 0; i < length; i++) {
                char ch = str.charAt(i);
                // 小写字母转到整数，需要-'a'
                counts[ch - 'a']++;
            }

            String key = Arrays.toString(counts);

            List<String> list = (map.getOrDefault(key, new ArrayList<String>()));
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
    }
}