package com.phrolova.algorithm.hot100.p0101_symmetric_tree;

import com.phrolova.algorithm.hot100.common.TreeNode;

public class SymmetricTree {

    // 递归
    public boolean isSymmetricRecursion(TreeNode root) {
        return check(root.left, root.right);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    public static void main(String[] args) {
    }
}
