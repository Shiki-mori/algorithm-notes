package com.phrolova.algorithm.sorting.simple;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSortExchange(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i - (j + 1)] <= arr[i - j]) {
                    break;
                }
                swap(arr, i - (j + 1), i - j);
            }
        }
    }

    public static void insertionSortMove(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        for (int i = 1; i < arr.length; i++) {
            // 当前需要插入的元素
            int current = arr[i];
            // 有序区域的最后一个元素位置
            int j = i - 1;
            // 比current大的元素向后移动
            while (arr[j] > current && j > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            // 在正确的位置插入
            arr[j + 1] = current;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }
}
