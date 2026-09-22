package com.phrolova.algorithm.leetcode.p1493_longest_subarray_of_1s_after_deleting_one_element;

public class LongestSubarrayOf1sAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int n = nums.length;

        int left = 0;
        int lsum = 0;
        int rsum = 0;

        int maxLength = 0;

        for (int right = 0; right < n; right++) {
            // 先处理rsum，不处理lsum，相当于preSum[r]-preSum[l-1]
            rsum += nums[right];
            if (rsum - lsum == right - left || rsum - lsum == right - left + 1) {
                maxLength = Math.max(maxLength, right - left);
            }
            while (rsum - lsum < right - left) {
                lsum += nums[left];
                left++;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
    }
}
