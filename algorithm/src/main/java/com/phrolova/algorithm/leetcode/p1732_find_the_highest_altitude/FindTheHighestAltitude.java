package com.phrolova.algorithm.leetcode.p1732_find_the_highest_altitude;

public class FindTheHighestAltitude {

    public int largestAltitude(int[] gain) {
        // 每个点的海拔
        int[] heights = new int[gain.length + 1];
        int max_height = 0;

        for (int height = 1; height <= gain.length; height++) {
            heights[height] = heights[height - 1] + gain[height - 1];
            max_height = Math.max(max_height, heights[height]);
        }
        return max_height;
    }

    public int largestAltitudePrefix(int[] gain) {
        int ans = 0, sum = 0;
        for (int x : gain) {
            sum += x;
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public static void main(String[] args) {
    }
}
