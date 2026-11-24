package com.phrolova.algorithm.hot100.p0543_diameter_of_binary_tree;

import com.phrolova.algorithm.hot100.common.TreeNode;

public class DiameterOfBinaryTree {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        lengthOfRoot(root);
        return diameter;
    }

    public int lengthOfRoot(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = lengthOfRoot(root.left);
        int right = lengthOfRoot(root.right);

        // 以当前节点为拐点的最长路径
        diameter = Math.max(diameter, left + right);

        // 返回给父节点的是深度，只能选一边
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
    }
}
