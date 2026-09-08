package com.phrolova.algorithm.leetcode.p0933_number_of_recent_calls;

import java.util.*;
import java.io.*;

/**
 * ACM 笔试输入（对应 LeetCode 示例）：
 *
 * 5
 * RecentCounter
 * ping 1
 * ping 100
 * ping 3001
 * ping 3002
 *
 * ACM 笔试输出：
 *
 * null
 * 1
 * 2
 * 3
 * 3
 */

public class Main {
    // === 原代码（保留）===
    // Queue<Integer> queue;
    //
    // static final int LIMIT_TIME = 3000;
    //
    // public RecentCounter() {
    //     queue = new ArrayDeque<Integer>();
    // }
    //
    // public int ping(int t) {
    //     queue.offer(t);
    //     while (queue.peek() < t - LIMIT_TIME) {
    //         queue.poll();
    //     }
    //     return queue.size();
    // }

    static class RecentCounter {
        Queue<Integer> queue;
        static final int LIMIT_TIME = 3000;

        public RecentCounter() {
            queue = new ArrayDeque<Integer>();
        }

        public int ping(int t) {
            queue.offer(t);
            while (queue.peek() < t - LIMIT_TIME) {
                queue.poll();
            }
            return queue.size();
        }
    }

    // === 原代码（保留）===
    // public void main(String[] args) throws IOException {
    //     BufferReader br = new BufferReader(new InputStreamReader(System.in));
    //     PrintWriter out = new PrintWriter(System.out);
    //
    //     StringTokenizer st = StringTokenizer(br.readLine());
    //     int n = st.nextToken();
    //     for (int i = 0; i < n; i++) {
    //         StringTokenizer st1 = StringTokenizer(br.readLine());
    //         string op = st1.nextToken();
    //         switch (op) {
    //             case RecentCounter:
    //                 RecentCounter recentCounter = new RecentCounter();
    //                 out.println(null);
    //             case ping:
    //                 t = st1.nextToken();
    //                 out.println(recentCounter.ping(t));
    //         }
    //     }
    //     out.flush();
    // }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine().trim());
        RecentCounter recentCounter = null;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            switch (op) {
                case "RecentCounter":
                    recentCounter = new RecentCounter();
                    out.println("null");
                    break;
                case "ping":
                    int t = Integer.parseInt(st.nextToken());
                    out.println(recentCounter.ping(t));
                    break;
                default:
                    throw new IllegalArgumentException("unknown op: " + op);
            }
        }
        out.flush();
    }
}