package com.phrolova.algorithm.hot100.p0114_flatten_binary_tree_to_linked_list;

import com.phrolova.algorithm.hot100.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;

public class FlattenBinaryTreeToLinkedList {

    // 先序遍历存到链表中
    public void flattenList(TreeNode root) {
        List<TreeNode> temp = new ArrayList<>();
        dfs(root, temp);

        int size = temp.size();
        for (int i = 0; i < size - 1; i++) {
            TreeNode node = temp.get(i);
            node.left = null;
            node.right = temp.get(i + 1);
        }
    }

    public void dfs(TreeNode root, List<TreeNode> temp) {
        if (root == null) {
            return;
        }

        temp.add(root);

        dfs(root.left, temp);
        dfs(root.right, temp);
    }

    // -------------------------------------------------
    // 反向后序递归

    private TreeNode next;

    public void flattenRecursive(TreeNode root) {
        next = null;
        dfs1(root);
    }

    public void dfs1(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs1(node.right);
        dfs1(node.left);

        node.right = next;
        node.left = null;
        next = node;
    }

    // -----------------------------------------------
    // 找前驱节点

    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            // 遇到存在左子树的节点时进入该if-分支
            if (cur.left != null) {
                TreeNode pre = cur.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                // 左子树最右下侧的节点接上当前节点的右子树
                pre.right = cur.right;
                // 左子树移到当前节点的右子树
                cur.right = cur.left;
                // 当前节点的左孩子置null
                cur.left = null;
            }
            cur = cur.right;
        }
    }

    public static void main(String[] args) {
    }
}
