package com.phrolova.algorithm.leetcode.p2300_successful_pairs_of_spells_and_potions;

public class SuccessfulPairsOfSpellsAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;

        int[] pairs = new int[n];
        Arrays.sort(potions);

        for (int i = 0; i < n; i++) {
            int l = 0;
            int r = m - 1;
            int temp = 0;
            long target = (long) ((success + spells[i] - 1) / spells[i]);
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (potions[mid] >= target) {
                    r = mid - 1;
                    temp = mid;
                } else {
                    l = mid + 1;
                    temp = 0;
                }
            }
            pairs[i] = m - temp;
        }
        return pairs;
    }

    // --------------------------------------------
    // 双指针

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;

        int[] pairs = new int[n];

        // 保存spells原数组和排序后数组的映射关系
        int[][] spellInOrder = new int[n][2];
        for (int i = 0; i < n; i++) {
            spellInOrder[i][0] = spells[i];
            spellInOrder[i][1] = i;
        }
        Arrays.sort(spellInOrder, (a, b) -> Integer.compare(a[0], b[0]));

        // 倒序potions
        Arrays.sort(potions);
        reverseArr(potions);

        int i = 0, j = 0;
        while (i < n && j < m) {
            if ((long) spellInOrder[i][0] * potions[j] < success) {
                pairs[spellInOrder[i++][1]] = j;
            } else {
                j++;
            }
        }
        if (i < n) {
            for (int i0 = i; i < n; i++) {
                pairs[spellInOrder[i][1]] = j;
            }
        }

        return pairs;
    }

    public void reverseArr(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
    }

    // ---------------------------------
    // 双指针官解

    public int[] successfulPairsOfficial(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;

        int[] pairs = new int[n];

        // 保存spells原数组和排序后数组的映射关系
        int[][] spellInOrder = new int[n][2];
        for (int i = 0; i < n; i++) {
            spellInOrder[i][0] = spells[i];
            spellInOrder[i][1] = i;
        }
        Arrays.sort(spellInOrder, (a, b) -> Integer.compare(a[0], b[0]));

        // 倒序potions
        Arrays.sort(potions);
        reverseArr(potions);

        for (int i = 0, j = 0; i < n; i++) {
            // 原索引
            int p = spellInOrder[i][1];
            // 升序排序结果
            int v = spellInOrder[i][0];

            while (j < m && (long) v * potions[j] >= success)

                j++;
            pairs[p] = j;
        }
        return pairs;
    }


    public static void main(String[] args) {
    }
}
