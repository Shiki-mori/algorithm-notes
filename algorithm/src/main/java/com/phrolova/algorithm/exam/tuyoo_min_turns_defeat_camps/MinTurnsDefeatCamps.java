package com.phrolova.algorithm.exam.tuyoo_min_turns_defeat_camps;

public class MinTurnsDefeatCamps {

    public static void main(String[] args) {
    }

    public int minRounds(int n, int x, int y, int[] enemies) {
        int maxHp = 0;
        // 找出最大敌人生命值
        for (int i = 0; i < n; i++) {
            if (enemies[i] > maxHp) 
                maxHp = enemies[i];
        }
    
        int lo = 1, hi = maxHp;
    
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canFinish(n, x, y, enemies, mid)) 
                hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
    
    boolean canFinish(int n, int x, int y, int[] enemies, int t) {
        int need = 0;
        for (int i = 0; i < n; i++) {
            int rest = subY(enemies[i], y, t);
            if (rest <= 0) 
                continue;
            need += (rest + x - 1) / x;
            if (need > t) 
                return false;
        }
        return true;
    }
    
    int subY(int h, int y, int t) {
        if (t > (h - 1) / y) 
            return 0;
        return h - t * y;
    }

    public static int minTurn(int n, int x, int y, int[] enemies) {
        int minturn = 0;

        return minturn;
    }
}
