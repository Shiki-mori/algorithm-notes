package com.phrolova.algorithm.leetcode.p0198_house_robber;

public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n < 3) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = dp[0] + nums[2];

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
        }

        return Math.max(dp[n - 1], dp[n - 2]);
    }

    // ----------------------
    // 滚动数组优化

    public int robWindow(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }

        return second;
    }

    public static void main(String[] args) {
    }
}
