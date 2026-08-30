package com.phrolova.algorithm.leetcode.p0392_is_subsequence;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0, k = 0;

        for (i = 0; i < s.length(); i++) {
            for (; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    k++;
                    j++;
                    break;
                }
            }
        }
        if (k == s.length())
            return true;
        return false;
    }

    public boolean official1(String s, String t) {
        int i = 0, j = 0;
        int m = s.length(), n = t.length();

        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == m;
    }

    public boolean officialDP(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                // j+'a':将int j转为char
                if (t.charAt(i) == j + 'a') {
                    f[i][j] = i;
                } else {
                    f[i][j] = f[i + 1][j];
                }
            }
        }

        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
