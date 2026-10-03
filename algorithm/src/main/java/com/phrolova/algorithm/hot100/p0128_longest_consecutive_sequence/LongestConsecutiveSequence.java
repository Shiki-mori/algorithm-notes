package com.phrolova.algorithm.hot100.p0128_longest_consecutive_sequence;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;

        for (int val : set) {
            if (set.contains(val - 1))
                continue;

            // val对应的最长连续序列长度
            int series = 1;
            int i = 1;
            while (set.contains(val + i)) {
                i++;
                series++;
            }
            maxLength = Math.max(maxLength, series);
        }

        return maxLength;
    }

    public static void main(String[] args) {
    }
}
