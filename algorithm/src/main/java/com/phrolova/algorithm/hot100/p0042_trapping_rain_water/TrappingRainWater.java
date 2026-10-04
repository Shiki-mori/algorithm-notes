package com.phrolova.algorithm.hot100.p0042_trapping_rain_water;

public class TrappingRainWater {

    // 暴力
    public int trapBrute(int[] height) {

        int[] newHeight = new int[height.length + 2];
        System.arraycopy(height, 0, newHeight, 1, height.length);

        int sum = 0;

        for (int i = 1; i < newHeight.length - 1; i++) {
            // 寻找左侧最大高度
            int left = i - 1;
            int maxLeft = 0;
            while (left > 0) {
                maxLeft = Math.max(maxLeft, newHeight[left]);
                left--;
            }
            // 寻找右侧最大高度
            int right = i + 1;
            int maxRight = 0;
            while (right < newHeight.length - 1) {
                maxRight = Math.max(maxRight, newHeight[right]);
                right++;
            }

            // i接雨水：
            int rainI = Math.min(maxLeft, maxRight) - newHeight[i];
            sum += (rainI > 0 ? rainI : 0);

        }
        return sum;
    }

    // 前缀数组

    public int trap(int[] height) {

        int length = height.length;
        int sum = 0;

        // i位置表示该位置左侧的最大高度
        int[] leftMax = new int[length];

        int[] rightMax = new int[length];
        
        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(height[i - 1], leftMax[i - 1]);
        }

        for (int i = length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i + 1], rightMax[i + 1]);
        }

        for (int i = 0; i < length; i++) {
            int rainI = Math.min(leftMax[i], rightMax[i]) - height[i];
            sum += (rainI > 0 ? rainI : 0);
        }

        return sum;
    }

    // 双指针

    public int trap2Points(int[] height) {

        int length = height.length;
        int sum = 0;

        int leftMax = 0;
        int rightMax = 0;

        int left = 0;
        int right = length - 1;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                sum += leftMax - height[left];
                left++;
            } else {
                sum += rightMax - height[right];
                right--;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
    }
}
