package com.phrolova.algorithm.hot100.p0001_two_sum;

public class TwoSum {

    // -----------------------------------------
    // 双指针
    public int[] twoSum(int[] nums, int target) {

        int n = nums.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            // [i][0]存储值
            // [i][1]存储下标
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        int left = 0;
        int right = n - 1;

        while (left < right) {
            if (pairs[left][0] + pairs[right][0] == target) {
                break;
            } else if (pairs[left][0] + pairs[right][0] < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] { pairs[left][1], pairs[right][1] };
    }

    // -----------------------------------------
    // 哈希表

    public int[] twoSumHashMap(int[] nums, int target) {
        // <值，下标>
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i)

                return new int[] { i, map.get(target - nums[i]) };
        }

        return new int[] { -1, -1 };
    }

    // ---------------------------------------
    // 哈希表优化

    public int[] twoSumHashMap2(int[] nums, int target) {
        // <值，下标>
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[] { i, map.get(target - nums[i]) };
            map.put(nums[i], i);
        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
    }
}
