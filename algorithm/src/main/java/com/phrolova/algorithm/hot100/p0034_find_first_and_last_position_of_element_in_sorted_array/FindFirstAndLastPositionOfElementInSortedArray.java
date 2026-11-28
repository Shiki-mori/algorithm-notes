package com.phrolova.algorithm.hot100.p0034_find_first_and_last_position_of_element_in_sorted_array;

public class FindFirstAndLastPositionOfElementInSortedArray {
    // 初版写法
    public int[] searchRange0(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        int begin = -1;
        int end = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                begin = binarySearchLeft(nums, 0, mid, target);
                end = binarySearchRight(nums, mid, nums.length - 1, target);
                break;
            }
        }

        return new int[]{begin, end};
    }

    // 寻找可能在左半边的begin
    private int binarySearchLeft(int[] nums, int begin, int end, int target) {
        int left = begin;
        int right = end;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }

        return result;
    }

    // 寻找可能在右半边的end
    private int binarySearchRight(int[] nums, int begin, int end, int target) {
        int left = begin;
        int right = end;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                result = mid;
                left = mid + 1;
            }
        }

        return result;
    }

    // ------------------------------------------------------
    // 合并辅助函数

    public int[] searchRange1(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        int begin = -1;
        int end = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                begin = binarySearch(nums, left, mid, target, true);
                end = binarySearch(nums, mid, right, target, false);
                break;
            }
        }

        return new int[]{begin, end};
    }

    private int binarySearch(int[] nums, int left, int right, int target, boolean isBegin) {

        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                result = mid;
                if (isBegin) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return result;
    }

    // -------------------------------------------------
    // 直接对整个数组二分

    public int[] searchRange(int[] nums, int target) {
        int begin = binarySearch(nums, 0, nums.length - 1, target, true);
        int end = binarySearch(nums, 0, nums.length - 1, target, false);
        return new int[]{begin, end};
    }

    public static void main(String[] args) {
    }
}
