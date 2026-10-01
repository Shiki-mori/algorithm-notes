package com.phrolova.algorithm.hot100.p0104_maximum_depth_of_binary_tree;

import com.phrolova.algorithm.hot100.common.TreeNode;

public class MaximumDepthOfBinaryTree {

    // BFS
    public int maxDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }

    // ----------------------------------------------
    // DFS

    public int maxDepth(TreeNode root) {
        return (root == null) ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
    }
}
