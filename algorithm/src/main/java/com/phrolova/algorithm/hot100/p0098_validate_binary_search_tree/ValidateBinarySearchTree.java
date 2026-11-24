package com.phrolova.algorithm.hot100.p0098_validate_binary_search_tree;

import com.phrolova.algorithm.hot100.common.TreeNode;

import java.awt.desktop.PreferencesEvent;

public class ValidateBinarySearchTree {

    // 递归
    public boolean isValidBSTRecursive(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // 判断以根为节点的树，所有值是否都在(min, high)范围内，且为搜索树
    public boolean check(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return check(root.left, min, root.val) && check(root.right, root.val, max);
    }

    // ----------------------------------------
    // 中序遍历
    private long prev;

    public boolean isValidBST(TreeNode root){
        prev=Long.MIN_VALUE;
        return inorder(root);
    }

    private boolean inorder(TreeNode root){
        if(root==null){
            return true;
        }

        // 判断左子树合格
        if(!inorder(root.left)){
            return false;
        }

        // 根
        if(root.val<=prev){
            return false;
        }

        prev=root.val;

        // 右
        return inorder(root.right);
    }

    public static void main(String[] args) {
    }
}
