package com.phrolova.algorithm.leetcode.p0208_implement_trie_prefix_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * ACM 笔试输入（对应 LeetCode 示例）：
 *
 * 7
 * Trie
 * insert apple
 * search apple
 * search app
 * startsWith app
 * insert app
 * search apple
 *
 * ACM 笔试输出：
 *
 * null
 * null
 * true
 * false
 * true
 * null
 * true
 */
public class Main {

    static class Trie {
        private Trie[] children;
        private boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private Trie searchPrefix(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine().trim());
        Trie trie = null;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            switch (op) {
                case "Trie":
                    trie = new Trie();
                    out.println("null");
                    break;
                case "insert":
                    trie.insert(st.nextToken());
                    out.println("null");
                    break;
                case "search":
                    out.println(trie.search(st.nextToken()));
                    break;
                case "startsWith":
                    out.println(trie.startsWith(st.nextToken()));
                    break;
                default:
                    throw new IllegalArgumentException("unknown op: " + op);
            }
        }

        out.flush();
    }
}
