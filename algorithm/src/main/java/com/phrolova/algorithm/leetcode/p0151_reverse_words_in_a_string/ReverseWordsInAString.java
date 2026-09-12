package com.phrolova.algorithm.leetcode.p0151_reverse_words_in_a_string;

public class ReverseWordsInAString {
    public String reverseWordsAPI(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    //--------------------------------------------

    public String reverseWords(String s) {
        StringBuilder sb = trimSpaces(s);

        // 先翻转整个字符串
        // 得到的结果中，单词都是反的
        reverse(sb, 0, sb.length() - 1);

        // 翻转每个单词
        reverseEachWord(sb);

        return sb.toString();
    }

    public StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉开头空字符
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }

        // 去掉结尾空字符
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }
        // 去掉中间多余的空字符
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);

            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                // 如果当前是空格，只有sb的末尾不是空格（上一个append的是字符）才append
                // 最终只留下一个空格
                sb.append(c);
            }

            left++;
        }
        return sb;
    }

    public void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }

    public void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;

        while (start < n) {
            // 循环至单词的末尾
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            // 翻转单词
            reverse(sb, start, end - 1);
            // 更新start，寻找下一个单词
            start = end + 1;
            end++;
        }
    }

    // ------------------------------------------

    public String reverseWordsDeque(String s) {
        int n = s.length();
        int left = 0, right = n - 1;

        // 去掉开头的空白
        while (left <= right && s.charAt(left) == ' ')
            left++;

        // 去掉结尾的空白
        while (left < right && s.charAt(right) == ' ')
            right--;

        Deque<String> d = new ArrayDeque<String>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                // 读到空格，且word不为空，说明读完一个单词
                // 将单词push到队列头部
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                // 当前不为空格，说明未读完一个单词，继续读
                word.append(c);
            }
            // 读到空格，且word为空，说明连续空格，不进入if直接跳过
            left++;
        }
        // 循环中只有后面有空格的单词入队（“读到空格”）
        // 最后一个单词后面没有空格，单独入队
        d.offerFirst(word.toString());

        return String.join(" ", d);
    }

    public static void main(String[] args) {
    }
}
