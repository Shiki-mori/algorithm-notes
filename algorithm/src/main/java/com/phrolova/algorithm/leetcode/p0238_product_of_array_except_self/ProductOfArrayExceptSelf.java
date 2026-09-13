package com.phrolova.algorithm.leetcode.p0238_product_of_array_except_self;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelfBrute(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int ans = 1;
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    ans *= nums[j];
                }
            }
            answer[i] = ans;
        }
        return answer;
    }

    // -------------------------------------
    // 左右乘积列表

    public int[] productExceptSelf_fix_(int[] nums) {
        int n = nums.length;
        int[] L = new int[n];
        int[] R = new int[n];

        L[0] = 1;
        R[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        for (int j = n - 2; j >= 0; j--) {
            R[j] = R[j + 1] * nums[j + 1];
        }

        int[] answer = new int[n];
        for (int k = 0; k < n; k++) {
            answer[k] = L[k] * R[k];
        }
        return answer;
    }

    public int[] productExceptSelfSpaceO1(int[] nums) {
        int n = nums.length;
        // 表示索引左侧乘积
        int[] answer = new int[n];

        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // R为索引右侧乘积
        int R = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * R;
            // R更新为下一个索引(i-1)的右侧乘积
            R *= nums[i];
        }
        return answer;
    }

    public static void main(String[] args) {
    }
}
