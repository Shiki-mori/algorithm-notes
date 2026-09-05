package com.phrolova.algorithm.leetcode.p0062_unique_paths;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int i = 0, j = 0;
        return dfs(i, j, m - 1, n - 1);
    }

    public int dfs(int i, int j, int m, int n) {

        if (i == m && j == n) {
            return 1;
        }

        int count = 0;
        if (i < m)
            count += dfs(i + 1, j, m, n);
        if (j < n)
            count += dfs(i, j + 1, m, n);

        return count;
    }

    public int uniquePathsDP(int m, int n) {
        // dp[i][j]表示从起点到[i][j]的路径数量
        int[][] dp = new int[m][n];
        // 将所有 i=0 与 j=0 的情况设为边界
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePathsComb(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; x++, y++) {
            ans = ans * x / y;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
    }
}
