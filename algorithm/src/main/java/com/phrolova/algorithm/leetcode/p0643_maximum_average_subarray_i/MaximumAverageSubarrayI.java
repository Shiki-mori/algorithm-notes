package com.phrolova.algorithm.leetcode.p0643_maximum_average_subarray_i;

public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        double max = Double.MIN_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++) {
            double sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }
            if (max < sum / k) {
                max = sum / k;
            }
        }
        return max;
    }

    public double official(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double max = sum;

        for (int i = 0; i < nums.length - k; i++) {
            sum += -nums[i] + nums[i + k];
            if (max < sum) {
                max = sum;
            }
        }

        return max / k;
    }

    public static void main(String[] args) {
    }
}
