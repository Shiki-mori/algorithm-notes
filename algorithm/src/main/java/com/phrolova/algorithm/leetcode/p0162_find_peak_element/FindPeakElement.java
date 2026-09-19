package com.phrolova.algorithm.leetcode.p0162_find_peak_element;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                idx = i;
        }
        return idx;
    }

    // --------------------------
    // 爬坡迭代

    public int findPeakElementClimb(int[] nums) {
        int n = nums.length;
        int idx = (int) (Math.random() * n);

        while (!(compare(nums, idx - 1, idx) < 0 && compare(nums, idx, idx + 1) > 0)) {
            if (compare(nums, idx, idx + 1) < 0) {
                idx++;
            } else {
                idx--;
            }
        }

        return idx;
    }

    // 辅助函数：输入下标i，返回一个二元组（0/1，nums[i]）,表示nums[i]是否合法
    // 不合法的索引-1和n对应的nums[i]=-Integer.MAX_VALUE
    // 方便处理边界情况

    public int[] get(int[] nums, int idx) {
        if (idx == -1 || idx == nums.length) {
            return new int[] { 0, 0 };
        }
        return new int[] { 1, nums[idx] };
    }

    public int compare(int[] nums, int idx1, int idx2) {
        int[] num1 = get(nums, idx1);
        int[] num2 = get(nums, idx2);

        // nums[i]有一个不合法
        if (num1[0] != num2[0]) {
            // nums[idx1]合法，说明第一个索引对应的值更大，返回1；
            // nums[idx2]合法，说明第二个索引对应的值更大，返回-1
            return num1[0] > num2[0] ? 1 : -1;
        }
        // 相等
        if (num1[1] == num2[1]) {
            return 0;
        }
        return num1[1] > num2[1] ? 1 : -1;
    }

    // ------------------------------------------
    // 二分

    public int findPeakElementBinary(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;

        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (compare(nums, mid - 1, mid) < 0 && compare(nums, mid, mid + 1) > 0) {
                ans = mid;
                break;
            }
            if (compare(nums, mid, mid + 1) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
    }
}
