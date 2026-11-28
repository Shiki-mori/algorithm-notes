package com.phrolova.algorithm.hot100.p0033_search_in_rotated_sorted_array;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int k = findMinIndex(nums);
        if (target >= nums[k] && target <= nums[n - 1]) {
            return binarySearch(nums, k, n - 1, target);
        }
        return binarySearch(nums, 0, k - 1, target);
    }

    // 二分找旋转点：最小值的下标
    // 比较 nums[mid] nums[right]
    private int findMinIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /*

    5 6 7 8 1 2 3 4
    1 2 3 4 5 6 7 8

     */

    public static void main(String[] args) {
    }
}
