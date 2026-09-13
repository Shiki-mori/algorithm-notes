package com.phrolova.algorithm.leetcode.p1679_max_number_of_k_sum_pairs;

import java.util.Map;

public class MaxNumberOfKSumPairs {
    public int maxOperationsBrute(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        boolean[] isRead = new boolean[n];
        for (int i = 0; i < n - 1; i++) {
            // 已经读过的j跳过
            if (isRead[i] == true) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (isRead[j] == true) {
                    continue;
                }
                if (nums[i] + nums[j] == k) {
                    isRead[j] = true;
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    // ---------------------------------------------
    // 双指针

    public int maxOperations2Ptrs(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        Arrays.sort(nums);

        int l = 0;
        int r = n - 1;

        while (l < r) {
            if (nums[l] + nums[r] < k) {
                // 此时如果右指针左移，和只会更小
                // 因此左指针右移
                l++;
            } else if (nums[l] + nums[r] == k) {
                count++;
                l++;
                r--;
            } else {
                // 此时如果左指针右移，和只会更大
                // 因此右指针左移
                r--;
            }
        }
        return count;
    }

    // ---------------------------
    // 哈希

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            // 对每个num，查看map中是否有补数k-num
            int c = cnt.getOrDefault(k - num, 0);
            if (c > 0) {
                cnt.put(k - num, c - 1);
                ans++;
            } else {
                cnt.merge(num, 1, Integer::sum);
                // 等价于：
                // cnt.merge(num, 1, (oldVal, val) -> Integer.sum(oldVal, val));
                // 或：
                // cnt.put(num, cnt.getOrDefault(num, 0) + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
    }
}
