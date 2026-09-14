package com.phrolova.algorithm.leetcode.p0724_find_pivot_index;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] L = new int[n];
        int[] R = new int[n];

        for (int i = 1; i < n; i++) {
            L[i] = L[i - 1] + nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            R[i] = R[i + 1] + nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            if (L[i] == R[i]) {
                return i;
            }
        }
        return -1;
    }

    // ---------------------------
    // official

    public int pivotIndexOfficial(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum == total - nums[i]) {
                return i;
            }
            // 下一轮循环的i左侧元素和
            sum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
    }
}
