package com.phrolova.algorithm.leetcode.p0739_daily_temperatures;

import java.util.*;
import java.io.*;

/**
 * ACM 笔试输入（对应 LeetCode 示例）：
 *
 * 8
 * 73 74 75 71 69 72 76 73
 *
 * ACM 笔试输出：
 *
 * 1 1 4 2 1 1 0 0
 */

// === 原代码（保留）===
// class Main {
public class Main {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return answer;
    }

    // === 原代码（保留）===
    // public static main(String[] args){
    //     BufferedReader br=new BufferedReader(System.in);
    //     PrintWriter out=new PrintWriter(System.out);
    //
    //     StringTokenizer st=new StringTokenizer(br.readLine());
    //     int n=st.nextToken();
    //     int[] temperatures=new int[n];
    //     StringTokenizer st1=new StringTokenizer(br.readLine());
    //     for(int i=0;i<n;i++){
    //         temperatures[i]=st1.nextToken();
    //     }
    //
    //     int[] answer=dailyTemperatures(temperatures);
    //     for(int i=0;i<n;i++){
    //         out.println(answer[i]);
    //     }
    //     out.flush();
    // }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] temperatures = new int[n];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            temperatures[i] = Integer.parseInt(st1.nextToken());
        }

        int[] answer = dailyTemperatures(temperatures);
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                out.print(' ');
            }
            out.print(answer[i]);
        }
        out.println();
        out.flush();
    }
}