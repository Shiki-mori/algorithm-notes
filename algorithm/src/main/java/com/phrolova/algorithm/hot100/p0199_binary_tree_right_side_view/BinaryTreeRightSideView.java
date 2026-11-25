package com.phrolova.algorithm.hot100.p0199_binary_tree_right_side_view;

import com.phrolova.algorithm.hot100.common.TreeNode;

import java.util.*;

public class BinaryTreeRightSideView {
    // BFS
    public List<Integer> rightSideViewBFS(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode node = null;
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(node.val);
        }

        return ans;
    }

    // ------------------------------------------------
    // DFS

    private List<Integer> ans;

    public List<Integer> rightSideViewDFS(TreeNode root) {
        ans = new ArrayList<>();
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth == ans.size()) {
            ans.add(root.val);
        }
        dfs(root.right, depth + 1);
        dfs(root.left, depth + 1);
    }

    public static void main(String[] args) {
    }
}
