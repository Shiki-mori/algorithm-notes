package com.phrolova.algorithm.leetcode.p0017_letter_combinations_of_a_phone_number;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        backtrack(combinations, phoneMap, digits, 0, new StringBuilder());
        return combinations;
    }

    // index：当前处理的数字
    // combination：当前已选字母路径
    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index,
            StringBuilder combination) {
        
        // 终止条件
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            // index位置的数字 映射的所有字母
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                // 收取答案后，删除上一个添加的字母
                combination.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
    }
}
