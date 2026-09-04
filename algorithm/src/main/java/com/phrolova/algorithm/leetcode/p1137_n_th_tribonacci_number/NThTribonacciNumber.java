package com.phrolova.algorithm.leetcode.p1137_n_th_tribonacci_number;

public class NThTribonacciNumber {
    public int tribonacci(int n) {
        int[] arr = new int[n + 1];
        if (arr.length == 1) {
            return 0;
        } else if (arr.length == 2) {
            return 1;
        }
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;

        for (int i = 0; i <= n - 3; i++) {
            arr[i + 3] = arr[i] + arr[i + 1] + arr[i + 2];

        }
        return arr[n];
    }

    public int tribonacciDP(int n) {

        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        int p = 0, q = 0, r = 1, s = 1;
        for (int i = 3; i <= n; i++) {
            p = q;
            q = r;
            r = s;
            s = p + q + r;
        }
        return s;
    }

    public static void main(String[] args) {
    }
}
