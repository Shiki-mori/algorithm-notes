package com.phrolova.algorithm.leetcode.p0374_guess_number_higher_or_lower;

import com.phrolova.algorithm.leetcode.common.GuessGame;

public class GuessNumberHigherOrLower extends GuessGame {
    public int guessNumber(int n) {
        int left = 1, right = n,
                mid = left + (right - left) / 2;

        while (left < right) {
            // pick<num
            if (guess(mid) == -1) {
                right = mid - 1;
                mid = left + (right - left) / 2;
            } else if (guess(mid) == 1) {
                left = mid + 1;
                mid = left + (right - left) / 2;
            } else {
                return mid;
            }
        }
        return mid;
    }

    public int guessNumberOfficial(int n) {
        int left = 1, right = n;
        while (left < right) { // 循环直至区间左右端点相同
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (guess(mid) <= 0) {
                right = mid; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }

    public static void main(String[] args) {
    }
}
