package com.phrolova.algorithm.leetcode.p0875_koko_eating_bananas;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        Arrays.sort(piles);
        int left = 1, right = piles[n - 1];
        int k = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (calculateTime(piles, mid) <= h) {
                // 吃得完
                right = mid -1;
                // 再减速度，吃不完就结束
                if (calculateTime(piles, mid - 1) > h) {
                    k = mid;
                    break;
                }
            } else if (calculateTime(piles, mid) > h) {
                // 吃不完
                left = mid + 1;
            } 
            System.out.println(k);
        }
        
        return k;

    }

    public int calculateTime(int[] piles, int v) {
        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            sum += (piles[i] + v - 1) / v;
        }
        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
    }
}
