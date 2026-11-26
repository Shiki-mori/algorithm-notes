package com.phrolova.algorithm.hot100.p0105_construct_binary_tree_from_preorder_and_inorder_traversal;

import com.phrolova.algorithm.hot100.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    // 递归
    private Map<Integer, Integer> inorderIndex;
    private int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        inorderIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }
        return build(0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }

        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);

        int k = inorderIndex.get(rootVal);
        int leftSize = k - inLeft;

        root.left = build(preLeft + 1, preLeft + leftSize, inLeft, k - 1);
        root.right = build(preLeft + leftSize + 1, preRight, k + 1, inRight);

        return root;
    }

    public static void main(String[] args) {
    }
}
