package com.phrolova.algorithm.hot100.p0560_subarray_sum_equals_k;

public class SubarraySumEqualsK {

    // 前缀和
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int length = nums.length;

        int[] pre = new int[length];
        pre[0] = nums[0];

        for (int i = 1; i < length; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (i == 0) {
                    if (pre[j] == k) {
                        ans++;
                    }

                    continue;
                }

                if (pre[j] - pre[i - 1] == k) {
                    ans++;
                }
            }
        }

        return ans;
    }

    // -----------------------------------------
    // dp

    public int subarraySumDP(int[] nums, int k) {
        int ans = 0;
        int length = nums.length;

        int[][] dp = new int[length][length];
        dp[0][0] = nums[0];

        for (int i = 0; i < length; i++) {
            if (i > 0)
                dp[i][0] = dp[i - 1][0] - nums[i - 1];
            for (int j = i; j < length; j++) {
                if (j > 0) {
                    dp[i][j] = dp[i][j - 1] + nums[j];
                }
                if (dp[i][j] == k)
                    ans++;
            }
        }

        return ans;
    }

    // ----------------------------------------
    // 哈希表优化前缀和

    public int subarraySumHashMap(int[] nums, int k) {
        int ans = 0;
        int length = nums.length;

        int[] pre = new int[length];

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        for (int i = 0; i < length; i++) {
            if (i == 0)
                pre[i] = nums[i];
            else {
                pre[i] = pre[i - 1] + nums[i];
            }
            ans += map.getOrDefault(pre[i] - k, 0);
            map.put(pre[i], map.getOrDefault(pre[i], 0) + 1);
        }
        return ans;
    }

    // ------------------------------------
    // 不用数组
    
    public int subarraySumNoArray(int[] nums, int k) {
        int ans = 0;
        int pre = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            if (i == 0)
                pre = nums[i];
            else {
                pre += nums[i];
            }
            ans += map.getOrDefault(pre - k, 0);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
    }
}
