package com.phrolova.algorithm.sorting.simple;

public class OddTimesNum {
    public static int oneOddTimesNum(int[] arr) {
        int a = 0;
        for (int num : arr) {
            a ^= num;
        }
        return a;
    }

    public static int[] twoOddTimesNum(int[] arr) {
        int eor = 0, onlyOne = 0;
        for (int num : arr) {
            eor ^= num;
        }

        //eor至少有一位为1
        int rightOne = eor & (~eor + 1);//提取出最右的1
        for (int num : arr) {
            if ((num & rightOne) == 0) {
                onlyOne ^= num;
            }
        }

        return new int[]{onlyOne, onlyOne ^ eor};
    }


}
