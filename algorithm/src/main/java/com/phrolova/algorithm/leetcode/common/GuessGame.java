package com.phrolova.algorithm.leetcode.common;

/**
 * LeetCode interactive stub for problems like Guess Number Higher or Lower.
 */
public class GuessGame {
    private int picked = 0;

    public void setPicked(int picked) {
        this.picked = picked;
    }

    /**
     * @return -1 if num is higher than the picked number,
     *          1 if num is lower than the picked number,
     *          0 if equal
     */
    protected int guess(int num) {
        if (num > picked) {
            return -1;
        }
        if (num < picked) {
            return 1;
        }
        return 0;
    }
}
