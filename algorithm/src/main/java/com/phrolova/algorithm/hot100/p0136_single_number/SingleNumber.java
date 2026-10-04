package com.phrolova.algorithm.hot100.p0136_single_number;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
    }
}
