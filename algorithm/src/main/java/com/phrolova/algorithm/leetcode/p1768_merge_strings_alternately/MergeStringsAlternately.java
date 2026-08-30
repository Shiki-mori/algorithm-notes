package com.phrolova.algorithm.leetcode.p1768_merge_strings_alternately;

public class MergeStringsAlternately {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder merged = new StringBuilder();
        int i;
        for (i = 0; i < Math.min(word1.length(), word2.length()); i++) {
            merged.append(word1.charAt(i));
            merged.append(word2.charAt(i));
        }
        if (word1.length() < word2.length()) {
            merged.append(word2.substring(i));
        } else if (word1.length() > word2.length()) {
            merged.append(word1.substring(i));
        }

        return merged.toString();
    }

    public String official(String word1, String word2) {

        StringBuilder ans = new StringBuilder();
        int l1 = word1.length();
        int l2 = word2.length();
        int i = 0, j = 0;

        while (i < l1 || j < l2) {
            if (i < l1) {
                ans.append(word1.charAt(i));
                i++;
            }
            if (j < l2) {
                ans.append(word2.charAt(j));
                j++;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
    }
}
