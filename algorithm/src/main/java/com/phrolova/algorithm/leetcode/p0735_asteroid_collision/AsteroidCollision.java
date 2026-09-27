package com.phrolova.algorithm.leetcode.p0735_asteroid_collision;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int aster : asteroids) {
            boolean alive = true;
            while (alive && aster < 0 && !stack.isEmpty() && stack.peek() > 0) {
                alive = stack.peek() < -aster;
                if (stack.peek() <= -aster) {
                    stack.pop();
                }
            }
            if (alive == true) {
                stack.push(aster);
            }
        }

        int size = stack.size();
        int[] ans = new int[size];

        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }

        return ans;
    }

    public static void main(String[] args) {
    }
}
