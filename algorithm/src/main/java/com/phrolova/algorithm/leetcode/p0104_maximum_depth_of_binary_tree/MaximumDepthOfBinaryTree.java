package com.phrolova.algorithm.leetcode.p0104_maximum_depth_of_binary_tree;

import com.phrolova.algorithm.leetcode.common.TreeNode;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // +1是当前节点本身占一层高度
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int maxDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        // ans：已遍历层数
        int ans = 0;
        while (!queue.isEmpty()) {      // 外层：是否还存在待处理节点
            int size = queue.size();        // 当前层有几个节点
            while (size > 0) {      // 内层：处理完当前层的所有节点
                TreeNode node = queue.poll();
                // 新加入的节点将在下一轮循环中被处理
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            // 该层全部处理完，ans+1
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
    }
}
