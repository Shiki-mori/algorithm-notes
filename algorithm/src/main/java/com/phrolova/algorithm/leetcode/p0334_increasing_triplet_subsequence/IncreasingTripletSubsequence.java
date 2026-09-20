package com.phrolova.algorithm.leetcode.p0334_increasing_triplet_subsequence;

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3)
            return false;

        int[] leftMin = new int[n];
        int[] rightMax = new int[n];

        leftMin[0] = nums[0];
        rightMax[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
            rightMax[n - 1 - i] = Math.max(rightMax[n - i], nums[i]);
        }

        for (int i = 1; i < n - 1; i++) {
            if (leftMin[i - 1] < nums[i] && nums[i] < rightMax[i + 1]) {
                System.out.println(i);
                return true;
            }
        }
        return false;
    }

    // ------------------------------------
    // 贪心

    public boolean increasingTripletGreed(int[] nums) {
        int n = nums.length;
        if (n < 3)
            return false;

        int first = nums[0];
        int second = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            if (nums[i] > second) {
                return true;
            } else if (nums[i] > first) {
                second = nums[i];
            } else {
                first = nums[i];
            }
        }

        return false;
    }

    public static void main(String[] args) {
    }
}
