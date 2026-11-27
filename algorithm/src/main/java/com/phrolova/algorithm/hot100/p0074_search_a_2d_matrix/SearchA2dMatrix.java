package com.phrolova.algorithm.hot100.p0074_search_a_2d_matrix;

public class SearchA2dMatrix {
    public boolean searchMatrixBinarySearchTwice(int[][] matrix, int target) {
        int row = binarySearchColumn(matrix, target);
        if (row == -1)
            return false;
        return binarySearchRow(matrix[row], target);
    }

    // 初版写法
    private int binarySearchColumn0(int[][] matrix, int target) {
        int rows = matrix.length;
        int up = 0, down = rows - 1;
        while (up <= down) {
            int mid = up + (down - up) / 2;
            if (target < matrix[mid][0]) {
                if (mid > 0 && target > matrix[mid - 1][0]) {
                    return mid - 1;
                }
                down = mid - 1;
            } else if (target > matrix[mid][0]) {
                if ((mid + 1 < rows && target < matrix[mid + 1][0]) || mid == rows - 1) {
                    return mid;
                }
                up = mid + 1;
            } else {
                return mid;
            }
        }

        return 0;
    }

    private int binarySearchColumn(int[][] matrix, int target) {
        int rows = matrix.length;
        int up = 0, down = rows - 1;
        while (up <= down) {
            int mid = up + (down - up) / 2;
            if (target < matrix[mid][0]) {
                down = mid - 1;
            } else if (target > matrix[mid][0]) {
                up = mid + 1;
            } else {
                return mid;
            }
        }

        return down;
    }

    private boolean binarySearchRow(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < row[mid]) {
                right = mid - 1;
            } else if (target > row[mid]) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        /*
        二维矩阵转为一维数组：
        matrix[i][j]->matrix[i*length+j]
        一维数组转为二维矩阵：
        matrix[i]->matrix[i/length][i%length]
        */
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = arrToMatrix(matrix, mid, cols);
            if (target < midValue) {
                right = mid - 1;
            } else if (target > midValue) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    private int arrToMatrix(int[][] matrix, int index, int length) {
        return matrix[index / length][index % length];
    }

    public static void main(String[] args) {
    }
}
