package com.phrolova.algorithm.leetcode.p1207_unique_number_of_occurrences;

public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (Integer value : map.values()) {
            set.add(value);
        }
        return map.size() == set.size();
    }

    public static void main(String[] args) {
    }
}
