package com.phrolova.algorithm.hot100.p0011_container_with_most_water;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        // 双指针
        // 初始：左右指针指向两端
        // 容积：短边*左右指针距离
        // 左右指针距离减小
        // 更短的那条边需要增大
        // 每次移动短边
        // 两边相同时，左右距离减小，短边不会变，需要更长的边。两边同时移动

        int left = 0;
        int right = height.length - 1;

        int maxVolumn = 0;
        while (left < right) {
            if (height[left] > height[right]) {
                maxVolumn = Math.max(height[right] * (right - left), maxVolumn);
                right--;
            } else {
                maxVolumn = Math.max(height[left] * (right - left), maxVolumn);
                left++;
            }
        }

        return maxVolumn;
    }

    // 尝试优化

    public int maxArea2(int[] height) {

        int length = height.length;
        int left = 0;
        int right = length - 1;

        int maxVolumn = 0;
        while (left < right) {
            if (height[left] > height[right]) {
                int h = height[right];
                maxVolumn = Math.max(h * (right - left), maxVolumn);
                while (left < right && height[right] <= h) {
                    right--;
                }
            } else {
                int h = height[left];
                maxVolumn = Math.max(h * (right - left), maxVolumn);
                while (left < right && height[left] <= h) {
                    left++;
                }
            }
        }

        return maxVolumn;
    }

    public static void main(String[] args) {
    }
}
