package com.phrolova.algorithm.leetcode.p1431_kids_with_the_greatest_number_of_candies;

import java.util.*;

public class KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        for (int candy : candies) {
            if (max < candy)
                max = candy;
        }
        List<Boolean> results = new ArrayList<>(Collections.nCopies(candies.length, false));
        // List<Boolean> results = new ArrayList<>(candies.length);
        // for (int candy : candies) {
        //     results.add(false);
        // }
        for (int i = 0; i < results.size(); i++) {
            if (candies[i] + extraCandies >= max)
                results.set(i, true);
        }
        return results;
    }

    public static void main(String[] args) {
    }
}
