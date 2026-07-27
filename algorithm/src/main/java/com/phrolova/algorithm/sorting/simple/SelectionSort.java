package com.phrolova.algorithm.sorting.simple;

public class SelectionSort {

    public static int[] selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            swap(arr, minArr(arr, i), i);
        }

        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int minArr(int[] arr, int j) {
        int min = j;
        for (int i = j + 1; i < arr.length; i++) {
            if (arr[min] > arr[i]) {
                min = i;
            }
        }
        return min;
    }
}
