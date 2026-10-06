package com.phrolova.algorithm.hot100.p0094_binary_tree_inorder_traversal;

import com.phrolova.algorithm.hot100.common.TreeNode;
import java.util.*;

public class BinaryTreeInorderTraversal {

    public List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) {
            return ans;
        }

        inorderTraversal(root.left);
        ans.add(root.val);
        inorderTraversal(root.right);

        // 先序遍历
        // ans.add(root.val);
        // inorderTraversal(root.left);
        // inorderTraversal(root.right);

        // 后序遍历
        // inorderTraversal(root.left);
        // inorderTraversal(root.right);
        // ans.add(root.val);

        return ans;
    }

    public static void main(String[] args) {
    }
}
