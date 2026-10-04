package com.phrolova.algorithm.hot100.p0015_3sum;

import java.util.*;

public class ThreeSum {

    // HashSet去重
    public List<List<Integer>> threeSumBrute(int[] nums) {

        Arrays.sort(nums);

        Set<String> set = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    set.add(nums[i] + "," + nums[left] + "," + nums[right]);
                    left++;
                    right--;
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (String s : set) {
            List<Integer> list = new ArrayList<>();
            String[] parts = s.split(",");
            for (String part : parts) {
                list.add(Integer.parseInt(part));
            }
            ans.add(list);
        }

        return ans;
    }

    // 判断去重

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }

                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    List<Integer> list = List.of(nums[i], nums[left], nums[right]);
                    ans.add(list);
                    left++;
                    right--;
                }
            }

        }

        return ans;
    }

    public static void main(String[] args) {
    }
}
