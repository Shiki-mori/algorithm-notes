package com.phrolova.algorithm.leetcode.p2352_equal_row_and_column_pairs;

public class EqualRowAndColumnPairs {
    
    public int equalPairsBrute(int[][] grid) {
        int n = grid.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (equal(i, j, n, grid)) {
                    count++;
                }
            }
        }
        return count;
    }

    // public boolean equal(int raw, int col, int n, int[][] grid) {
    //     int[] column = new int[n];
    //     for (int i = 0; i < n; i++) {
    //         column[i] = grid[i][col];
    //     }
    //     return Arrays.equals(grid[raw], column);
    // }

    public boolean equal(int raw, int col, int n, int[][] grid) {
        for (int i = 0; i < n; i++)
            if (grid[raw][i] != grid[i][col])
                return false;
        return true;
    }

    // -------------------------
    // Hash

    public int equalPairs(int[][] grid) {
        int n = grid.length;

        Map<List<Integer>, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<Integer> list = Arrays.stream(grid[i]).boxed().toList();
            map.put(list, map.getOrDefault(list, 0) + 1);
        }

        int count = 0;
        for (int col = 0; col < n; col++) {
            List<Integer> list = new ArrayList<>();
            for (int raw = 0; raw < n; raw++) {
                list.add(grid[raw][col]);
            }
            if (map.containsKey(list)) {
                // 逐列遍历
                // 当与行匹配时，要加上所有与该列匹配的行数
                // 如果用count++，结果是“与该列匹配的至少有一行”
                // count++;
                count += map.get(list);
            }
        }

        return count;
    }

    public static void main(String[] args) {
    }
}
