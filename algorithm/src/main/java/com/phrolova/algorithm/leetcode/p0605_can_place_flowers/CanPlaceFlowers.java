package com.phrolova.algorithm.leetcode.p0605_can_place_flowers;

public class CanPlaceFlowers {
    // 失败，边界条件混乱，部分用例错误
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 最多插入max朵花
        int max = 0;
        if (flowerbed.length == 1 && flowerbed[0] == 0)
            max = 1;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                int series = 0;
                for (int j = i; j < flowerbed.length; j++) {
                    if (flowerbed[j] == 0) {
                        series++;
                    } else {
                        break;
                    }
                }
                if (i == 0 && (i + series - 1 == flowerbed.length - 1) && series > 1) {
                    max += series / 2 - (series + 1) % 2 + 2;
                } else if ((i == 0 || (i + series - 1 == flowerbed.length - 1)) && series > 1) {
                    max += series / 2 - (series + 1) % 2 + 1;
                } else {
                    max += series / 2 - (series + 1) % 2;
                }
                i += series;

            }
            if (max >= n)
                return true;
        }
        return false;
    }

    public boolean canPlaceFlowers0(int[] flowerbed, int n) {
        // 最多插入max朵花
        int max = 0;
        // 数组前后补0，去除边界影响
        int[] flowerbed0 = new int[flowerbed.length + 2];
        for (int i = 0; i < flowerbed.length; i++) {
            flowerbed0[i + 1] = flowerbed[i];
        }

        for (int i = 0; i < flowerbed0.length; i++) {
            if (flowerbed0[i] == 0) {
                int series = 0;
                for (int j = i; j < flowerbed0.length; j++) {
                    if (flowerbed0[j] == 0) {
                        series++;
                    } else {
                        break;
                    }
                }
                max += series / 2 - (series + 1) % 2;
                i += series;

            }
            if (max >= n)
                return true;
        }
        return false;
    }

    public boolean canPlaceFlowersGreedy(int[] flowerbed, int n) {

        int flower[] = new int[flowerbed.length + 2];
        System.arraycopy(flowerbed, 0, flower, 1, flowerbed.length);
        for (int i = 1; i < flower.length - 1; i++) {
            if (flower[i - 1] == 0 && flower[i] == 0 && flower[i + 1] == 0) {
                flower[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }

    public static void main(String[] args) {
    }
}
