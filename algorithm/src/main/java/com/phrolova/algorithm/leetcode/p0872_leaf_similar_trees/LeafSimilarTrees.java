package com.phrolova.algorithm.leetcode.p0872_leaf_similar_trees;

import com.phrolova.algorithm.leetcode.common.TreeNode;

public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();
        dfs(root1, r1);
        dfs(root2, r2);

        return r1.equals(r2);
    }

    // 错误写法
    // root = root.left;将节点更新为左孩子，后续判断右孩子不为空时，判断的是左孩子的右孩子root.left.rights
    // public void dfs(TreeNode root, List<Integer> r) {
    // if (root.left != null) {
    // root = root.left;
    // dfs(root, r);
    // }
    // if (root.right != null) {
    // root = root.right;
    // dfs(root, r);
    // }
    // if (root.left == null && root.right == null) {
    // r.add(root.val);
    // }
    // }

    public void dfs(TreeNode root, List<Integer> r) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            r.add(root.val);
            return;
        }
        dfs(root.left, r);
        dfs(root.right, r);
    }

    // ---------------------------------
    // official

    public void dfsOfficial(TreeNode root, List<Integer> r) {
        if (root.left == null && root.right == null) {
            r.add(root.val);
            return;
        }
        if (root.left != null) {
            dfs(root.left, r);
        }
        if (root.right != null) {
            dfs(root.right, r);
        }
    }

    public static void main(String[] args) {
    }
}
