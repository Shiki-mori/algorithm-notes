package com.phrolova.algorithm.leetcode.p0700_search_in_a_binary_search_tree;

import com.phrolova.algorithm.leetcode.common.TreeNode;

public class SearchInABinarySearchTree {
    public TreeNode searchBST1(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        return searchBST(val < root.val ? root.left : root.right, val);
    }

    public TreeNode searchBST2(TreeNode root, int val) {
        while (root != null) {
            if (val == root.val) {
                return root;
            }
            root = val < root.val ? root.left : root.right;
        }
        return null;
    }

    public static void main(String[] args) {
    }
}
