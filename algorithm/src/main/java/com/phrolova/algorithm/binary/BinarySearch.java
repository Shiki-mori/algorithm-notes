package com.phrolova.algorithm.binary;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {

        if (arr == null) {
            return -1;
        }

        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target > arr[mid]) {
                left = mid + 1;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static int firstPositionNotLessThanTarget(int[] arr, int target) {
        if (arr == null || arr.length == 0 || arr[arr.length - 1] < target) {
            return -1;
        }

        int left = 0, right = arr.length - 1;
        int leftTick = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid - 1;
                leftTick = mid;
            } else {
                left = mid + 1;
            }
        }
        return leftTick;
    }

    public static int localMinimum(int[] arr) {
        if (arr == null)
            return -1;
        if (arr.length < 2)
            return 0;

        if (arr[0] < arr[1])
            return 0;
        if (arr[arr.length - 1] < arr[arr.length - 2])
            return arr.length - 1;


        // 已经排除过arr[0]和arr[arr.length-1]，在[1,arr.length-2]区间搜索
        int left = 1;
        int right = arr.length - 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid - 1] < arr[mid]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return left;
    }
}
