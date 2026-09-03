package com.phrolova.algorithm.leetcode.p0841_keys_and_rooms;

import java.util.*;

public class KeysAndRooms {
    // 标记当前节点是否访问过
    boolean[] vis;
    // 可以到达的节点个数
    int num;

    public boolean canVisitAllRoomsDFS(List<List<Integer>> rooms) {
        int n = rooms.size();
        num = 0;
        vis = new boolean[n];
        dfs(rooms, 0);
        return num == n;

    }

    public void dfs(List<List<Integer>> rooms, int x) {
        vis[x] = true;
        num++;
        for (int it : rooms.get(x)) {
            if (!vis[it]) {
                dfs(rooms, it);
            }
        }
    }

    public boolean canVisitAllRoomsBFS(List<List<Integer>> rooms) {
        int n = rooms.size();
        int num = 0;
        boolean[] vis = new boolean[n];

        Queue<Integer> queue = new LinkedList<Integer>();
        vis[0] = true;
        queue.offer(0);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            num++;
            for (int it : rooms.get(x)) {
                if (!vis[it]) {
                    vis[it] = true;
                    queue.offer(it);
                }
            }
        }
        return num == n;
    }

    public static void main(String[] args) {
    }
}
