package com.phrolova.algorithm.leetcode.p0001_two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (seen.containsKey(need)) {
                return new int[]{seen.get(need), i};
            }
            seen.put(nums[i], i);
        }
        throw new IllegalArgumentException("no solution");
    }

    public static void main(String[] args) {
        TwoSum solver = new TwoSum();
        System.out.println(Arrays.toString(solver.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(solver.twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(solver.twoSum(new int[]{3, 3}, 6)));
    }
}
