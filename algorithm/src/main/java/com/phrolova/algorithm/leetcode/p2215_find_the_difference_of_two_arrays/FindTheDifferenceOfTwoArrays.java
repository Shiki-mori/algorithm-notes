package com.phrolova.algorithm.leetcode.p2215_find_the_difference_of_two_arrays;

import java.util.*;

public class FindTheDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            answer.add(new ArrayList<>());
        }

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }

        for (int i : set1) {
            if (!set2.contains(i)) {
                answer.get(0).add(i);
            }
        }

        for (int i : set2) {
            if (!set1.contains(i)) {
                answer.get(1).add(i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
    }
}
