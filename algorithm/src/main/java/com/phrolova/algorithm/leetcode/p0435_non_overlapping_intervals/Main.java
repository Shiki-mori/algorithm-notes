package com.phrolova.algorithm.leetcode.p0435_non_overlapping_intervals;

// === 原代码（保留）===
// import java.*;
// import java.io.PrintWriter;
// import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * ACM 笔试输入（对应 LeetCode 示例）：
 *
 * 4
 * 1 2
 * 2 3
 * 3 4
 * 1 3
 *
 * ACM 笔试输出：
 *
 * 1
 */
public class Main {

    // === 原代码（保留）===
    // public int eraseOverlapIntervalsGreedy(int[][] intervals) {
    public static int eraseOverlapIntervalsGreedy(int[][] intervals) {
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

    // === 原代码（保留）===
    // public void main(Strings args[]) {
    //     // 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
    //     // 4
    //     // 1 2
    //     // 2 3
    //     // 3 4
    //     // 1 3
    //     // 输出: 1
    //     StringBufferedReader s = new StringBufferedReader(new InputStreamReader());
    //     StringTokenizer st = new StringTokenizer(s.readline());
    //     int n = st.nextToken();
    //     int[][] intervals = new int[n][2];
    //     for (int i = 0; i < n - 1; i++) {
    //         StringTokenizer st0 = new StringTokenizer(s.readline());
    //         intervals[i][0] = st0.nextToken();
    //         intervals[i][1] = st0.nextToken();
    //     }
    //     System.println(eraseOverlapIntervalsGreedy(intervals));
    //
    // }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st0 = new StringTokenizer(br.readLine());
            intervals[i][0] = Integer.parseInt(st0.nextToken());
            intervals[i][1] = Integer.parseInt(st0.nextToken());
        }
        out.println(eraseOverlapIntervalsGreedy(intervals));

        out.flush();
    }
}
