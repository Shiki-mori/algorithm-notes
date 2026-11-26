package com.phrolova.algorithm.hot100.p0437_path_sum_iii;

import com.phrolova.algorithm.hot100.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSumIii {

    // 暴力
    public int pathSumBrute(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return countFrom(root, targetSum) + pathSumBrute(root.left, targetSum) + pathSumBrute(root.right, targetSum);
    }

    public int countFrom(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        int count = root.val == targetSum ? 1 : 0;
        count += countFrom(root.left, targetSum - root.val);
        count += countFrom(root.right, targetSum - root.val);
        return count;
    }

    // -----------------------------------------------
    // 前缀和 + 哈希表
    private Map<Long, Integer> prefixCount = new HashMap<>();
    private int target;

    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        // 存储从根到当前节点这一条链上，每个前缀和出现的次数
        prefixCount.put(0L, 1);
        return dfs(root, 0L);
    }

    // 返回终点在node这棵子树里的合法路径条数
    private int dfs(TreeNode node, long cur) {
        if (node == null) {
            return 0;
        }

        // 根到node的路径和
        cur += node.val;
        // 以node为终点的合法路径数
        int count = prefixCount.getOrDefault(cur - target, 0);

        // 进入：cur 出现次数 +1
        prefixCount.put(cur, prefixCount.getOrDefault(cur, 0) + 1);

        count += dfs(node.left, cur);
        count += dfs(node.right, cur);

        // 回溯：cur 出现次数 -1
        // 先递归左子树，递归结束后撤掉左子树登记过的前缀和，这样右子树使用的就是和左子树相同的cur
        prefixCount.put(cur, prefixCount.get(cur) - 1);

        return count;
    }

    public static void main(String[] args) {
    }
}
