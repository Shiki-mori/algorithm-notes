package com.phrolova.algorithm.leetcode.p0649_dota2_senate;

import java.util.Queue;

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        boolean[] alive = new boolean[n];
        Arrays.fill(alive, true);
        while (true) {
            for (int i = 0; i < n; i++) {

                if (alive[i] == false)
                    continue;
                boolean voted = false;
                switch (senate.charAt(i)) {
                    case 'R':
                        for (int j = i + 1; j < n + i; j++) {
                            int temp = j;
                            if (j >= n) {
                                temp -= n;
                            }
                            if (senate.charAt(temp) == 'D' && alive[temp] == true) {
                                alive[temp] = false;
                                voted = true;
                                break;
                            }
                        }
                        if (voted == false)
                            return "Radiant";
                        break;
                    case 'D':
                        for (int j = i + 1; j < n + i; j++) {
                            int temp = j;
                            if (j >= n) {
                                temp -= n;
                            }
                            if (senate.charAt(temp) == 'R' && alive[temp] == true) {
                                alive[temp] = false;
                                voted = true;
                                break;
                            }
                        }
                        if (voted == false)
                            return "Dire";
                        break;
                }
            }
        }
    }

    // ----------------------------------
    // Queue

    public String predictPartyVictoryQueue(String senate) {
        Queue<Integer> qR = new ArrayDeque<>();
        Queue<Integer> qD = new ArrayDeque<>();
        for (int i = 0; i < senate.length(); i++) {
            char ch = senate.charAt(i);
            if (ch == 'R') {
                qR.offer(i);
            } else {
                qD.offer(i);
            }
        }

        while (!qR.isEmpty() && !qD.isEmpty()) {
            int r = qR.poll();
            int d = qD.poll();
            if (r < d) {
                qR.offer(r + n);
            } else {
                qD.offer(d + n);
            }
        }
        
        if (qR.isEmpty()) {
            return "Dire";
        } else {
            return "Radiant";
        }
    }

    public static void main(String[] args) {
    }
}
