package com.phrolova.algorithm.leetcode.p0208_implement_trie_prefix_tree;

public class ImplementTriePrefixTree {

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
            // 子节点不存在
            if (node.children[index] == null) {
                // 在该节点创建一个新的子节点
                node.children[index] = new Trie();
            }
            // 无论是否存在，处理下一个字符
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

    public static void main(String[] args) {
    }
}
