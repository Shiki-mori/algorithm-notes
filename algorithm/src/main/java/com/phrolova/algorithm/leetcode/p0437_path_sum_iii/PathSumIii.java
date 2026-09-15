package com.phrolova.algorithm.leetcode.p0437_path_sum_iii;

import com.phrolova.algorithm.leetcode.common.TreeNode;

public class PathSumIii {

    // public int pathSum(TreeNode root, int targetSum) {
    //     return targetDFS(root, targetSum);
    // }

    // public int targetDFS(TreeNode root, int targetSum) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     if (targetSum == root.val) {
    //         return targetDFS(root.left, targetSum - root.val) + targetDFS(root.right, targetSum - root.val)
    //                 + targetDFS(root.left, targetSum) + targetDFS(root.right, targetSum) + 1;
    //     } else {
    //         return targetDFS(root.left, targetSum - root.val) + targetDFS(root.right, targetSum - root.val)
    //                 + targetDFS(root.left, targetSum) + targetDFS(root.right, targetSum);
    //     }
    // }

    // public int pathSum(TreeNode root, int targetSum) {
    //     return targetDFS(root, targetSum);
    // }

    // public int targetDFS(TreeNode root, int targetSum) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     int val = root.val;
    //     if (val == targetSum)
    //         return targetDFS(root.left, targetSum - val) + targetDFS(root.right, targetSum - val) + 1;
    //     return targetDFS(root.left, targetSum - val) + targetDFS(root.right, targetSum - val);
    // }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;

        int ans = targetDFS(root, targetSum);
        // 每次迭代需要加上以左孩子、右孩子为起点，符合条件的根数量
        return pathSum(root.left, targetSum) + pathSum(root.right, targetSum) + ans;
    }

    // 统计从root开始，符合条件的路径数量
    public int targetDFS(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        long val = root.val;
        if (val == targetSum)
            return targetDFS(root.left, targetSum - val) + targetDFS(root.right, targetSum - val) + 1;
        return targetDFS(root.left, targetSum - val) + targetDFS(root.right, targetSum - val);
    }

    // ------------------------
    // 前缀和

    public int pathSumPrefix(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return targetDFS(root, prefix, 0, targetSum);
    }

    public int targetDFS(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        // 从根到当前节点的和
        curr += root.val;

        ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += targetDFS(root.left, prefix, curr, targetSum);
        ret += targetDFS(root.right, prefix, curr, targetSum);
        // 回溯：当前节点结束后，将root到当前节点的前缀和移除
        // 否则兄弟子树将会使用到该节点
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }

    public static void main(String[] args) {
    }
}
