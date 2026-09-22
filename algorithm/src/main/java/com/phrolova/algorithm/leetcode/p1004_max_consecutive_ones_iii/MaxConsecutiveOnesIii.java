package com.phrolova.algorithm.leetcode.p1004_max_consecutive_ones_iii;

public class MaxConsecutiveOnesIii {
    // 二分查找
    public int longestOnesBinarySearch(int[] nums, int k) {
        int n = nums.length;

        // 构造前缀和数组
        int[] preSum = new int[n];
        preSum[0]=nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + 1 - nums[i];
        }

        // 记录最大区间长度
        int maxLength = 0;

        // 遍历右边界r
        for (int i = 0; i < n; i++) {
            int ll = 0;
            int lr = i;
            while (ll <= lr) {
                int mid = ll + (lr - ll) / 2;
                if (preSum[i] - preSum[mid] + 1 - nums[mid] <= k) {
                    maxLength = Math.max(i - mid + 1, maxLength);
                    lr = mid - 1;
                } else {
                    ll = mid + 1;
                }

            }
        }

        return maxLength;
    }

    // ------------------------------------------
    // 二分查找官解

    public int longestOnes(int[] nums, int k) {
        int n = nums.length;

        // 构造前缀和数组
        int[] P = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            P[i] = P[i - 1] + (1 - nums[i - 1]);
        }

        int ans = 0;
        for (int right = 0; right < n; right++) {
            int left = binarySearch(P, P[right + 1] - k);
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }

    public int binarySearch(int[] P, int target) {
        int low = 0;
        int high = P.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (P[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    // -----------------------------
    // 滑动窗口

    public int longestOnesWindows(int[] nums, int k) {
        int n = nums.length;

        int left = 0;
        // left和right对应的前缀和
        int lsum = 0;
        int rsum = 0;

        int ans = 0;

        for (int right = 0; right < n; right++) {
            rsum += 1 - nums[right];
            while (rsum - lsum > k) {
                lsum += 1 - nums[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
    }
}
