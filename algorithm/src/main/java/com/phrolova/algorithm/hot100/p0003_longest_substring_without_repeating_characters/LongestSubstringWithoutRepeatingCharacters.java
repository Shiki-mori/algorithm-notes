package com.phrolova.algorithm.hot100.p0003_longest_substring_without_repeating_characters;

public class LongestSubstringWithoutRepeatingCharacters {

    // 暴力
    public int lengthOfLongestSubstringBrute(String s) {
        int longestStream = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            StringBuilder newS = new StringBuilder(String.valueOf(s.charAt(i)));
            for (int j = 1; j < length - i; j++) {
                char newchar = s.charAt(i + j);
                if (newS.indexOf(String.valueOf(newchar)) != -1) {
                    break;
                }

                newS.append(newchar);
            }
            longestStream = Math.max(longestStream, newS.length());
        }

        return longestStream;
    }

    // 滑动窗口

    class Solution {

        public int lengthOfLongestSubstring(String s) {
    
            int length = s.length();
            if (length < 1)
                return 0;
    
            int longestStream = 1;
    
            int left = 0;
            int right = 1;
    
            Set<Character> letters = new HashSet<>();
            letters.add(s.charAt(left));
    
            while (left <= right && right < length) {
    
                // 不重复
                while (right < length && !letters.contains(s.charAt(right))) {
                    letters.add(s.charAt(right));
                    right++;
                }
                // 重复
                longestStream = Math.max(longestStream, right - left);
                letters.remove(s.charAt(left++));
            }
    
            return longestStream;
        }
    }

    public static void main(String[] args) {
    }
}
