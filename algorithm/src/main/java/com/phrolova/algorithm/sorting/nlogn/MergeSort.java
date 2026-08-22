package com.phrolova.algorithm.sorting.nlogn;

public class MergeSort {
    public static void mergeSort(int[] arr) {

        if (arr == null || arr.length < 2) return;
        int[] sorted = sort(arr, 0, arr.length - 1);
        System.arraycopy(sorted, 0, arr, 0, sorted.length);

    }

    public static int[] sort(int[] arr, int L, int R) {

        if (R - L < 1) return new int[]{arr[L]};

        int mid = L + (R - L) / 2;
        int[] left = sort(arr, L, mid);
        int[] right = sort(arr, mid + 1, R);
        return merge(left, right);
    }

    public static int[] merge(int[] L, int[] R) {
        int p1 = 0;
        int p2 = 0;
        int i = 0;
        int[] target = new int[L.length + R.length];
        while (p1 < L.length && p2 < R.length) {
            if (L[p1] <= R[p2]) {
                target[i++] = L[p1++];
            } else {
                target[i++] = R[p2++];
            }
        }
        while (p1 < L.length) {
            target[i++] = L[p1++];
        }
        while (p2 < R.length) {
            target[i++] = R[p2++];
        }
        return target;
    }
}
