package com.phrolova.algorithm.leetcode.p0199_binary_tree_right_side_view;

import com.phrolova.algorithm.leetcode.common.TreeNode;
import java.util.*;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideViewBFS(TreeNode root) {
        // 根据depth获取该depth下的最右节点
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
        int max_depth = -1;

        // 待访问的节点
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        // 对应节点所在的深度
        Queue<Integer> depthQueue = new LinkedList<Integer>();
        
        nodeQueue.offer(root);
        depthQueue.offer(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int depth = depthQueue.poll();

            if (node != null) {
                // 维护二叉树的最大深度
                max_depth = Math.max(max_depth, depth);

                // 当深度相同多次put时，新的val将会覆盖旧的val
                // 最后put的就是该层最右边的节点
                rightmostValueAtDepth.put(depth, node.val);

                nodeQueue.offer(node.left);
                nodeQueue.offer(node.right);
                depthQueue.offer(depth + 1);
                depthQueue.offer(depth + 1);
            }
        }

        List<Integer> rightView = new ArrayList<Integer>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        return rightView;
    }

    public static void main(String[] args) {
    }

    public List<Integer> rightSideViewDFS(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
        int max_depth = -1;

        Deque<TreeNode> nodeStack = new LinkedList<TreeNode>();
        Deque<Integer> depthStack = new LinkedList<Integer>();

        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            if (node != null) {
                // 维护二叉树的最大深度
                max_depth = Math.max(max_depth, depth);

                // 如果不存在对应深度的节点则插入：只保留第一个访问到的节点
                if (!rightmostValueAtDepth.containsKey(depth)) {
                    rightmostValueAtDepth.put(depth, node.val);
                }
                // 先push左，再push右，则在出栈处理时先处理右节点
                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }
        List<Integer> rightView = new ArrayList<Integer>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        return rightView;
    }
}
