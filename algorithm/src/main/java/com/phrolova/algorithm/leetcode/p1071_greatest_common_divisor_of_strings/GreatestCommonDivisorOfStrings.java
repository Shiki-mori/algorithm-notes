package com.phrolova.algorithm.leetcode.p1071_greatest_common_divisor_of_strings;

public class GreatestCommonDivisorOfStrings {
    
    // 解法1

    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        for (int i = Math.min(len1, len2); i >= 1; i--) {
            if (len1 % i == 0 && len2 % i == 0) {
                String pre = str1.substring(0, i);
                if (check(pre, str1) && check(pre, str2)) {
                    return pre;
                }
            }
        }
        return "";
    }

    public boolean check(String pre, String str) {
        int x = str.length() / pre.length();
        StringBuilder prex = new StringBuilder(pre);
        for (int i = 1; i < x; i++)
            prex.append(pre);
        return str.equals(prex.toString());
    }

    // 解法二

    public String gcdOfStringsGCD(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        String T = str1.substring(0, gcd(len1, len2));
        if (check(T, str1) && check(T, str2)) {
            return T;
        }
        return "";
    }

    // O(logn)
    public int gcd(int a, int b) {
        int remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }

    // 解法三：数学
    public String gcdOfStringsMath(String str1, String str2) {
        if ((str1 + str2).equals(str2 + str1)) {
            int len = gcd(str1.length(), str2.length());
            return str1.substring(0, len);
        }
        return "";
    }

    public static void main(String[] args) {
    }
}
