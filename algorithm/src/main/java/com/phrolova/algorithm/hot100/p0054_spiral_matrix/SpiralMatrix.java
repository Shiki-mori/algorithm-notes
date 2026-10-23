package com.phrolova.algorithm.hot100.p0054_spiral_matrix;

import java.util.*;

public class SpiralMatrix {
    // 模拟
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];

        List<Integer> order = new ArrayList<>();

        int total = rows * cols;
        int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int directionIndex = 0;

        int row = 0;
        int col = 0;

        for (int i = 0; i < total; i++) {
            order.add(matrix[row][col]);
            visited[row][col] = true;
            int nextRow = row + directions[directionIndex][0];
            int nextCol = col + directions[directionIndex][1];

            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || visited[nextRow][nextCol]) {
                directionIndex = (directionIndex + 1) % 4;
            }

            row += directions[directionIndex][0];
            col += directions[directionIndex][1];
        }

        return order;
    }

    // -----------------------------------------------
    // 按层模拟

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0, right = cols - 1;
        int top = 0, bottom = rows - 1;

        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j++) {
                order.add(matrix[top][j]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                order.add(matrix[i][right]);
            }
            if (left < right && top < bottom) {
                for (int j = right - 1; j >= left; j--) {
                    order.add(matrix[bottom][j]);
                }
                for (int i = bottom - 1; i >= top + 1; i--) {
                    order.add(matrix[i][left]);
                }
            }
            left++;
            top++;
            right--;
            bottom--;
        }

        return order;
    }

    public static void main(String[] args) {
    }
}
