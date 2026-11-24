package com.phrolova.algorithm.hot100.p0102_binary_tree_level_order_traversal;

import com.phrolova.algorithm.hot100.common.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    // 双列表
    public List<List<Integer>> levelOrder1(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // current 存当前层
        List<TreeNode> current = new ArrayList<>();
        current.add(root);

        while (!current.isEmpty()) {
            List<Integer> level = new ArrayList<>();  // 本层的值
            List<TreeNode> next = new ArrayList<>();  // 下一层的节点

            for (TreeNode node : current) {
                level.add(node.val);
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }

            result.add(level);
            current = next;
        }

        return result;
    }

    // 队列

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }

        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size=queue.size();  // 记录当前层的节点数
            List<Integer> level=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                level.add(node.val);

                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }

            result.add(level);
        }

        return result;
    }

    public static void main(String[] args) {
    }
}
