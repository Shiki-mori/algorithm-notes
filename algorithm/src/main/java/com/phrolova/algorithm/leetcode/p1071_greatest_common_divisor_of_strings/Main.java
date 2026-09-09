package com.phrolova.algorithm.leetcode.p1071_greatest_common_divisor_of_strings;

import java.util.*;
import java.io.*;

/**
 * ACM 笔试输入（对应 LeetCode 示例）：
 *
 * ABCABC
 * ABC
 *
 * ACM 笔试输出：
 *
 * ABC
 *
 * 示例 2 输入：
 * ABABAB
 * ABAB
 * 输出：
 * AB
 *
 * 示例 3 输入：
 * LEET
 * CODE
 * 输出：
 * （空行）
 *
 * 示例 4 输入：
 * AAAAAB
 * AAA
 * 输出：
 * （空行）
 */

public class Main {
    // === 原代码（保留）===
    // public String gcdOfStringsGCD(String str1, String str2) {
    public static String gcdOfStringsGCD(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        String T = str1.substring(0, gcd(len1, len2));
        if (check(T, str1) && check(T, str2)) {
            return T;
        }
        return "";
    }

    // O(logn)
    // === 原代码（保留）===
    // public int gcd(int a, int b) {
    public static int gcd(int a, int b) {
        int remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }

    // === 原代码（保留）===
    // public boolean check(String pre, String str) {
    public static boolean check(String pre, String str) {
        int x = str.length() / pre.length();
        StringBuilder prex = new StringBuilder(pre);
        for (int i = 1; i < x; i++)
            prex.append(pre);
        return str.equals(prex.toString());
    }

    // === 原代码（保留）===
    // public static void main(String[] args) {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     PrintWriter out = new PrintWriter(System.out);
    //
    //     StringTokenizer st1 = new StringTokenizer(br.readLine());
    //     String str1 = st1.nextToken();
    //     StringTokenizer st2 = new StringTokenizer(br.readLine());
    //     String str2 = st2.nextToken();
    //
    //     out.println(gcdOfStringsGCD(str1, str2));
    //     out.flush();
    // }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String str1 = br.readLine();
        String str2 = br.readLine();

        out.println(gcdOfStringsGCD(str1, str2));
        out.flush();
    }
}