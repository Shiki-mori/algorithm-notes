package com.phrolova.algorithm.hot100.p0073_set_matrix_zeroes;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeroes {
    // 暴力解
    public void setZeroesBrute(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<int[]> list0 = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    list0.add(new int[] { i, j });
                }
            }
        }

        for (int[] list : list0) {
            set0Row(matrix, list[0], n);
            set0Col(matrix, list[1], m);
        }
    }
    
    public void set0Row(int[][] matrix, int row, int n) {
        for (int j = 0; j < n; j++) {
            matrix[row][j] = 0;
        }
    }

    public void set0Col(int[][] matrix, int column, int m) {
        for (int i = 0; i < m; i++) {
            matrix[i][column] = 0;
        }
    }

    // -------------------------------------------
    // 标记数组

    public void setZeroesMarkArray(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // -------------------------------------------
    // 双标记变量

    public void setZeroesDoubleFlag(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flagCol0 = false;
        boolean flagRow0 = false;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagRow0 = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    // -------------------------------------------
    // 单标记变量

    public static void main(String[] args) {
    }
}
