package com.phrolova.algorithm.hot100.p0226_invert_binary_tree;

import com.phrolova.algorithm.hot100.common.TreeNode;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.right);
        invertTree(root.left);

        return root;
    }

    // ---------------------------------------
    // official

    public TreeNode invertTreeOfficial(TreeNode root) {

        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        
        return root;
    }

    public static void main(String[] args) {
    }
}
