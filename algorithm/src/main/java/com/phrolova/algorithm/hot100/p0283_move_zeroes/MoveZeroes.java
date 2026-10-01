package com.phrolova.algorithm.hot100.p0283_move_zeroes;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            swap(nums, i, index++);
        }
    }

    public void swap(int[] arr, int i, int index) {
        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }

    // -----------------------------------
    // 双指针

    public void moveZeroes2Points(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public static void main(String[] args) {
    }
}
