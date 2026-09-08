package com.phrolova.algorithm.leetcode.p0435_non_overlapping_intervals;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervalsDP(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
                // 不会溢出：return Integer.compare(interval1[0], interval2[0]);
            }
        });

        int n = intervals.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[j][1] <= intervals[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return n - Arrays.stream(dp).max().getAsInt();
    }

    public int eraseOverlapIntervalsGreedy(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        // O(nlogn)
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return Integer.compare(interval1[1], interval2[1]);
            }
        });

        // O(n)
        int n = intervals.length;
        int right = intervals[0][1];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= right) {
                right = intervals[i][1];
                count++;
            }
        }
        return n - count;
    }

    public static void main(String[] args) {
    }
}
