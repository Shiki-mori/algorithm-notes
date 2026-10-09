package com.phrolova.algorithm.hot100.p0238_product_of_array_except_self;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;

        int[] pre = new int[length];
        int[] aft = new int[length];

        pre[0] = 1;
        aft[length - 1] = 1;

        for (int i = 1; i < length; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
            aft[length - i - 1] = aft[length - i] * nums[length - i];
        }

        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            ans[i] = pre[i] * aft[i];
        }

        return ans;
    }

    // --------------------------------------------
    // O(1)

    public int[] productExceptSelfO1(int[] nums) {
        int length = nums.length;

        int[] ans = new int[length];
        ans[0] = 1;
        for (int i = 1; i < length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = length - 1; i >= 0; i--) {
            ans[i] *= right;
            right *= nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {
    }
}
