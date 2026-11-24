package com.phrolova.algorithm.hot100.p0108_convert_sorted_array_to_binary_search_tree;

import com.phrolova.algorithm.hot100.common.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    // 把 nums[left, right] 变成一棵树，返回根节点
    public TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = build(nums, left, mid - 1);
        root.right = build(nums, mid + 1, right);

        return root;
    }

    public static void main(String[] args) {
    }
}
