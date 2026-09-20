package com.phrolova.algorithm.leetcode.p1456_maximum_number_of_vowels_in_a_substring_of_given_length;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public int maxVowels(String s, int k) {

        int n = s.length();

        String vo = "aeiou";

        int[] vowels = new int[n - k + 1];
        // 初始化
        for (int i = 0; i < k; i++) {
            vowels[0] += isVowel(s, i, vo);
        }

        int maxVowel = vowels[0];

        for (int i = 1; i < vowels.length; i++) {
            vowels[i] = vowels[i - 1] + isVowel(s, i + k - 1, vo) - isVowel(s, i - 1, vo);
            maxVowel = Math.max(maxVowel, vowels[i]);
        }

        return maxVowel;
    }

    public int isVowel(String s, int i, String vo) {
        if (vo.indexOf(s.charAt(i)) < 0)
            return 0;

        return 1;
    }

    // -----------------------------------
    // 优化：仅维护一个最大值

    public int maxVowelsMaintainMax(String s, int k) {

        int n = s.length();

        String vo = "aeiou";

        int vowels = 0;
        // 初始化
        for (int i = 0; i < k; i++) {
            vowels += isVowel(s, i, vo);
        }

        int maxVowel = vowels;

        for (int i = 1; i < n - k + 1; i++) {
            vowels = vowels + isVowel(s, i + k - 1, vo) - isVowel(s, i - 1, vo);
            maxVowel = Math.max(maxVowel, vowels);
        }

        return maxVowel;
    }

    // ----------------------------------

    public int maxVowels1(String s, int k) {

        int n = s.length();

        int[] isVowel = new int[n];
        for (int i = 0; i < n; i++) {
            if ("aeiou".indexOf(s.charAt(i)) >= 0) {
                isVowel[i] = 1;
            }
        }
        
        int vowels = 0;
        for (int i = 0; i < k; i++) {
            vowels += isVowel[i];
        }

        int maxVowel = vowels;

        for (int i = 1; i < n - k + 1; i++) {
            vowels = vowels + isVowel[i + k - 1] - isVowel[i - 1];
            maxVowel = Math.max(maxVowel, vowels);
        }

        return maxVowel;
    }

    public static void main(String[] args) {
    }
}
