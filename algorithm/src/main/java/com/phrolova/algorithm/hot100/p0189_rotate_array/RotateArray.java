package com.phrolova.algorithm.hot100.p0189_rotate_array;

public class RotateArray {
    public void rotateNewArr(int[] nums, int k) {
        int length = nums.length;
        int[] newNums = new int[length];
        for (int i = 0; i < length; i++) {
            newNums[(i + k) % length] = nums[i];
        }

        System.arraycopy(newNums, 0, nums, 0, length);
    }
    
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        reverse(nums, 0, length - 1);
        reverse(nums, 0, k % length - 1);
        reverse(nums, k % length, length - 1);
    }

    public static void reverse(int[] nums, int a, int b) {
        while (a < b) {
            swap(nums, a, b);
            a++;
            b--;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
    }
}
