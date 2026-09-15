package com.phrolova.algorithm.leetcode.p1448_count_good_nodes_in_binary_tree;

import com.phrolova.algorithm.leetcode.common.TreeNode;

public class CountGoodNodesInBinaryTree {

    // 错误解法
    public int goodNodesW(TreeNode root) {
        int max = root.val;

        return dfsGood(root, max);
    }

    public int dfsGoodW(TreeNode root, int max) {
        if (root == null)
            return 0;

        int max_left = max;
        int max_right = max;

        if (root.left != null)
            max_left = Math.max(max, root.left.val);
        if (max_left >= max) {
            return dfsGood(root.left, max_left) + dfsGood(root.right, max_right) + 1;
        }

        if (root.right != null)
            max_right = Math.max(max, root.right.val);
        if (max_right >= max) {
            return dfsGood(root.left, max_left) + dfsGood(root.right, max_right) + 1;
        }

        return 0;
    }

    // ------------------------------
    // 

    public int goodNodes(TreeNode root) {
        int max = root.val;

        return dfsGood(root, max);
    }

    public int dfsGood(TreeNode root, int max) {
        if (root == null)
            return 0;

        if(root.val>=max){
            max=root.val;
            return dfsGood(root.left, max) + dfsGood(root.right, max) + 1;
        }else{
            return dfsGood(root.left, max) + dfsGood(root.right, max);
        }
    }

    public static void main(String[] args) {
    }
}
