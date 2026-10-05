package com.phrolova.algorithm.hot100.p0438_find_all_anagrams_in_a_string;

import java.util.*;

public class FindAllAnagramsInAString {

    // 排序，遍历
    public List<Integer> findAnagrams(String s, String p) {
        char[] p1 = p.toCharArray();
        Arrays.sort(p1); // p1是排序后的p，char数组

        List<Integer> ans = new ArrayList<>();

        int plen = p.length();

        for (int i = 0; i < s.length() - plen + 1; i++) {
            // System.out.println(i);
            String si = s.substring(i, i + plen);
            char[] sich = si.toCharArray();
            Arrays.sort(sich);
            if (Arrays.equals(sich, p1)) {
                ans.add(i);
            }
        }

        return ans;
    }

    // ---------------------------------------------------
    // 计数，滑动窗口

    public List<Integer> findAnagramsWindow(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        if (s.length() < p.length())
            return ans;

        int[] pCount = new int[26];
        int[] scount = new int[26];
        // 构造出p的字母集计数,s的初始字母集计数
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            scount[s.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = p.length() - 1;

        while (true) {
            if (Arrays.equals(scount, pCount)) {
                ans.add(left);
            }
            if (right == s.length() - 1) {
                break;
            }
            scount[s.charAt(left++) - 'a']--;
            scount[s.charAt(++right) - 'a']++;
        }

        return ans;
    }

    // --------------------------------------------
    // 优化滑动窗口
    // count[c] = p 里 c 的个数 - 当前窗口里 c 的个数
    // differ = count 中不为 0 的字母种类数；differ == 0 时窗口是异位词
    public List<Integer> findAnagramsOptimized(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        if (s.length() < p.length())
            return ans;

        // count[i]表示p里字母i的个数减去窗口中i的个数
        // count[i] 为正表示窗口里多了，为负表示窗口里少了，为0表示该字母数量相等
        int[] count = new int[26];
        for (int i = 0; i < p.length(); i++) {
            count[p.charAt(i) - 'a']--;
            count[s.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = p.length() - 1;

        // differ 是count里不为0的字母种类数
        int differ = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                differ++;
            }
        }

        // 滑动时，每次只会改变两个字母，并只会加减1
        // 对这两次改变分别处理，每次只修改一个字母的count
        // 仅当count[i]穿过0时，differ才发生变化
        // count[i]从非0变为0:不同字母-1，differ--
        // count[i]从0变为非0:不同字母+1，differ++
        while (true) {
            if (differ == 0) {
                ans.add(left);
            }
            if (right == s.length() - 1) {
                break;
            }

            // 移除的字母
            int out = s.charAt(left) - 'a';
            // 若移除前字母out数量相同，则移除后必然不同，differ++
            if (count[out] == 0) {
                differ++;
            }
            // 移除，窗口里out数量减少，count[out]--
            count[out]--;
            // 若移除后字母out数量相同，differ--
            if (count[out] == 0) {
                differ--;
            }

            left++;
            right++;

            // 放入的字母
            int in = s.charAt(right) - 'a';
            // 若放入前字母in数量相同，则放入后必然不同，differ++
            if (count[in] == 0) {
                differ++;
            }
            // 放入，窗口里in数量增加，count[in]++
            count[in]++;
            // 若放入后字母in数量相同，differ--
            if (count[in] == 0) {
                differ--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
    }
}
