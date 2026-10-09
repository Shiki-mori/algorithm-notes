package com.phrolova.algorithm.hot100.p0053_maximum_subarray;

public class MaximumSubarray {

    // dp
    public int maxSubArray(int[] nums) {
        int length = nums.length;

        int dp = nums[0];
        int maxSum = dp;

        for (int i = 1; i < length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            maxSum = Math.max(dp, maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
    }
}
