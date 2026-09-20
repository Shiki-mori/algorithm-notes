package com.phrolova.algorithm.leetcode.p0443_string_compression;

public class StringCompression {
    public int compress(char[] chars) {
        int n = chars.length;
        StringBuilder s = new StringBuilder();

        char temp = chars[0];

        int currcount = 1;
        for (int i = 1; i < n; i++) {
            if (chars[i] == temp) {
                currcount++;
            } else {
                temp = chars[i];
                s.append(chars[i - 1]);
                if (currcount > 1) {
                    s.append(String.valueOf(currcount));
                    currcount = 1;
                }
            }
        }
        s.append(temp);
        if (currcount > 1) {
            s.append(String.valueOf(currcount));
            currcount = 1;
        }

        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }

        return s.length();
    }

    // ---------------------------------------
    // 双指针

    public int compress2Points(char[] chars) {
        int n = chars.length;
        int write = 0, left = 0;

        for (int read = 0; read < n; read++) {
            if (read == n - 1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read];
                int len = read - left + 1;
                if (len > 1) {
                    int anchor = write;
                    while (len > 0) {
                        // len%10输出最低位。输出顺序将为：长度12->写入21
                        // 因此需要对这段[anchor, write-1]进行反转
                        chars[write++] = (char) (len % 10 + '0');
                        len /= 10;
                    }
                    reverse(chars, anchor, write - 1);
                }
                left = read + 1;

            }
        }
        return write;
    }

    public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
    }
}
