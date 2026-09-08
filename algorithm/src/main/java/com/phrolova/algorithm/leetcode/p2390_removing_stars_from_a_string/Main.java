package com.phrolova.algorithm.leetcode.p2390_removing_stars_from_a_string;

import java.util.*;
import java.io.*;

/**
 * ACM 笔试输入（对应 LeetCode 示例）：
 *
 * leetcod*e
 *
 * ACM 笔试输出：
 *
 * lecoe
 */

// === 原代码（保留）===
// class Main {
public class Main {
    public static String removeStars(String s) {
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                st.deleteCharAt(st.length() - 1);
            } else {
                st.append(s.charAt(i));
            }
        }
        return st.toString();
    }

    // === 原代码（保留）===
    // public static void main(String[] args) throws IOException {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     StringTokenizer st = new StringTokenizer(br.readLine());
    //     PrintWriter out = new PrintWriter(System.out);
    //     out.ptint(removeStars(st.nextToken()));
    //     out.flush();
    // }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String s = br.readLine();
        out.println(removeStars(s));
        out.flush();
    }
}