package com.phrolova.algorithm.leetcode.p1431_kids_with_the_greatest_number_of_candies;

import java.util.*;
import java.io.*;

/**
 * ACM 笔试输入（对应 LeetCode 示例）：
 *
 * 5
 * 2 3 5 1 3
 * 3
 *
 * ACM 笔试输出：
 *
 * true true true false true
 *
 * 示例 2 输入：
 * 5
 * 4 2 1 1 2
 * 1
 * 输出：
 * true false false false false
 *
 * 示例 3 输入：
 * 3
 * 12 1 12
 * 10
 * 输出：
 * true false true
 */

public class Main {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        for (int candy : candies) {
            if (max < candy)
                max = candy;
        }
        List<Boolean> results = new ArrayList<>(Collections.nCopies(candies.length, false));
        for (int i = 0; i < results.size(); i++) {
            if (candies[i] + extraCandies >= max)
                results.set(i, true);
        }
        return results;
    }

    // === 原代码（保留）===
    // public static void main(String[] args) {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     PrintWriter out = new PrintWriter(System.out);
    //     int length = Integer.parseInt(br.readLine());
    //
    //     StringTokenizer st = new StringTokenizer(br.readLine());
    //     int[] candies = new int[length];
    //     for (int i = 0; i < length; i++) {
    //         candies[i] = Integer.parseInt(st.nextToken());
    //     }
    //     int extraCandies = Integer.parseInt(br.readLine());
    //     out.println(kidsWithCandies(candies, extraCandies));
    //     out.flush();
    // }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int length = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] candies = new int[length];
        for (int i = 0; i < length; i++) {
            candies[i] = Integer.parseInt(st.nextToken());
        }
        int extraCandies = Integer.parseInt(br.readLine().trim());
        List<Boolean> results = kidsWithCandies(candies, extraCandies);
        for (int i = 0; i < results.size(); i++) {
            if (i > 0) {
                out.print(' ');
            }
            out.print(results.get(i));
        }
        out.println();
        out.flush();
    }
}