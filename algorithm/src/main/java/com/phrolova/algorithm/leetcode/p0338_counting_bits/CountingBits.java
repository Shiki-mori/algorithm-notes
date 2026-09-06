package com.phrolova.algorithm.leetcode.p0338_counting_bits;

public class CountingBits {
    public int[] countBitsAPI(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i < n + 1; i++)
            ans[i] = Integer.bitCount(i);

        return ans;
    }

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            int count = 0;
            int num = i;
            // 内层循环 log(num) 次
            while (num > 0) {
                count += num & 1; // 最低位是否为1
                num >>= 1; // 右移一位
            }
            ans[i] = count;
        }
        return ans;
    }

    public int[] countBitsBrianKernighan(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            int count = 0;
            int num = i;
            while (num > 0) {
                // 将最后一个1变成0
                num &= num - 1;
                count++;
            }
            // 循环次数即为1的个数
            ans[i] = count;
        }
        return ans;
    }

    public int[] countBitsHighBit(int n) {
        int[] bits = new int[n + 1];
        // 最高有效位
        int highbit = 0;
        for (int i = 1; i < n + 1; i++) {
            if ((i & (i - 1)) == 0) {
                highbit = i;
            }
            bits[i] = bits[i - highbit] + 1;
        }
        return bits;
    }

    public int[] countBitsLowBit(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }

    public int[] countBitsLowSet(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            bits[i] = bits[i & (i - 1)] + 1;
        }
        return bits;
    }

    public static void main(String[] args) {
    }
}
