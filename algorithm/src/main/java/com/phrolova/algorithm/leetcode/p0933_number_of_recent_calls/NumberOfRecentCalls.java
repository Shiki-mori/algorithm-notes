package com.phrolova.algorithm.leetcode.p0933_number_of_recent_calls;

public class NumberOfRecentCalls {
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

    public static void main(String[] args) {
    }
}
