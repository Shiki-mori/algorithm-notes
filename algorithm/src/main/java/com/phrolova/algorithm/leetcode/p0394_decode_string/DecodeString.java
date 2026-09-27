package com.phrolova.algorithm.leetcode.p0394_decode_string;

public class DecodeString {
    int ptr;

    public String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<String>();
        ptr = 0;

        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                // 拼接出一个数字，将这个完整的数字入栈
                String digits = getDigits(s);
                stack.addLast(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                stack.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                ptr++;  // else分支中不会用到ptr。该步使得下一轮循环从]右边的字符开始
                LinkedList<String> sub = new LinkedList<String>();
                while (!"[".equals(stack.peekLast())) {
                    sub.addLast(stack.removeLast());
                }
                Collections.reverse(sub);
                // 左括号出栈
                stack.removeLast();

                int repTime = Integer.parseInt(stack.removeLast());
                StringBuilder t = new StringBuilder();
                String o = getString(sub);

                // 构造字符串
                while (repTime-- > 0) {
                    t.append(o);
                }

                stack.addLast(t.toString());
            }
        }
        return getString(stack);
    }

    public String getDigits(String s) {
        StringBuilder ret = new StringBuilder();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }

        return ret.toString();
    }

    public String getString(LinkedList<String> v) {
        StringBuilder ret = new StringBuilder();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
    }
}
