package com.phrolova.algorithm.leetcode.p0345_reverse_vowels_of_a_string;

import java.util.HashSet;

public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        StringBuilder str = new StringBuilder(s);
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (set.contains(str.charAt(i)) || set.contains(str.charAt(j))) {
                if (set.contains(str.charAt(i))) {
                    if (set.contains(str.charAt(j))) {
                        swap(str, i++, j--);
                    } else {
                        j--;
                        continue;
                    }
                } else if (set.contains(str.charAt(j))) {
                    if (set.contains(str.charAt(i))) {
                        swap(str, i++, j--);
                    } else {
                        i++;
                    }
                }
            } else {
                i++;
                j--;
            }
        }
        // // 这样写更好：
        // while (i < j) {
        //     if (!set.contains(str.charAt(i))) {
        //         i++;
        //     } else if (!set.contains(str.charAt(j))) {
        //         j--;
        //     } else {
        //         swap(str, i++, j--);
        //     }
        // }

        return str.toString();
    }

    public void swap(StringBuilder s, int i, int j) {
        char temp = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, temp);
    }

    //-------------------------------------------------

    public String reverseVowelsOfficial(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int i = 0;
        int j = n - 1;
        while (i < j) {
            while (i < n && !isVowel(arr[i])) {
                i++;
            }
            while (j > 0 && !isVowel(arr[j])) {
                j--;
            }
            if (i < j) {
                swapArr(arr, i, j);
                i++;
                j--;
            }
        }
        return new String(arr);
    }

    public boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }

    public void swapArr(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
    }
}
