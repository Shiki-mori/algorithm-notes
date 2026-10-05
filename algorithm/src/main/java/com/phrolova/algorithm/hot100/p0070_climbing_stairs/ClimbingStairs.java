package com.phrolova.algorithm.hot100.p0070_climbing_stairs;

public class ClimbingStairs {

    // 递归
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    // ----------------------------------------
    // dp

    public int climbStairsDP(int n) {
        if (n <= 2)
            return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // ---------------------------------------
    // 空间复杂度优化

    public int climbStairsDPO1(int n) {
        if (n <= 2)
            return n;
        int pre1 = 1;
        int pre2 = 2;
        for (int i = 3; i <= n; i++) {
            int temp = pre2;
            pre2 = pre1 + pre2;
            pre1 = temp;
        }
        return pre2;
    }

    public static void main(String[] args) {
    }
}
