package com.phrolova.algorithm.hot100.p0056_merge_intervals;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();

        ans.add(intervals[0]);
        int count = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= ans.get(count)[1]) {
                int right = ans.get(count)[1];
                ans.get(count)[1] = Math.max(intervals[i][1], right);
            } else {
                ans.add(intervals[i]);
                count++;
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
    }
}
