package com.phrolova.algorithm.leetcode.p0011_container_with_most_water;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int n = height.length;

        int l = 0;
        int r = n - 1;

        int max = Math.min(height[l], height[r]) * (r - l);
        while (l < r) {
            if (height[l] <= height[r]) {
                l++;
            } else if (height[l] > height[r]) {
                r--;
            }
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));

        }

        return max;
    }

    public int maxAreaImprove(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r) {
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
    }
}
