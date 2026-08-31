package com.phrolova.algorithm.leetcode.p0283_move_zeroes;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {

        int l = nums.length - 1;
        int i = 0;
        while (i < l) {
            if (nums[i] == 0) {
                for (int j = i; j < l; j++) {
                    swap(nums, j, j + 1);
                }
                l--;
                if (nums[i] != 0) {
                    i++;
                }
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void official(int[] nums) {
        int n = nums.length;
        int left = 0, right = 0;
        while (right < n) {
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
