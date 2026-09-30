package com.phrolova.algorithm.leetcode.p1372_longest_zigzag_path_in_a_binary_tree;

import com.phrolova.algorithm.leetcode.common.TreeNode;

public class LongestZigzagPathInABinaryTree {
    private int ans;

    public int longestZigZag(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    // 返回 {第一步向左的长度, 第一步向右的长度}
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[] {0, 0};
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        // 第一步向左之后必须向右，接左孩子「第一步向右」的长度
        int goLeft = node.left == null ? 0 : left[1] + 1;
        int goRight = node.right == null ? 0 : right[0] + 1;
        ans = Math.max(ans, Math.max(goLeft, goRight));
        return new int[] {goLeft, goRight};
    }

    // -----------------------------------
    // 官解bfs

    Map<TreeNode, Integer> f = new HashMap<>();
    Map<TreeNode, Integer> g = new HashMap<>();

    Queue<TreeNode[]> q = new ArrayDeque<>();

    public int longestZigZagBFS(TreeNode root) {

        dp(root);
        int maxAns = 0;
        for (TreeNode u : f.keySet()) {
            maxAns = Math.max(maxAns, Math.max(f.get(u), g.get(u)));
        }

        return maxAns;
    }

    public void dp(TreeNode root) {
        f.put(root, 0);
        g.put(root, 0);
        q.offer(new TreeNode[] { root, null });

        while (!q.isEmpty()) {
            TreeNode[] y = q.poll();
            TreeNode u = y[0];
            TreeNode x = y[1];
            f.put(u, 0);
            g.put(u, 0);

            if (x != null) {
                if (x.left == u) {
                    f.put(u, g.get(x) + 1);
                }
                if (x.right == u) {
                    g.put(u, f.get(x) + 1);
                }
            }
            if (u.left != null) {
                q.offer(new TreeNode[] { u.left, u });
            }
            if (u.right != null) {
                q.offer(new TreeNode[] { u.right, u });
            }
        }
    }

    // ----------------------------------
    // 官解dfs

    int maxAns;

    public int longestZigZagDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxAns = 0;
        dfs(root, false, 0);
        dfs(root, true, 0);
        return maxAns;
    }

    public void dfs(TreeNode root, boolean dir, int len) {
        maxAns = Math.max(maxAns, len);

        if (!dir) {
            if (root.left != null) {
                dfs(root.left, true, len + 1);
            }
            if (root.right != null) {
                dfs(root.right, false, 1);
            }
        } else {
            if (root.left != null) {
                dfs(root.left, true, 1);
            }
            if (root.right != null) {
                dfs(root.right, false, len + 1);
            }
        }
    }

    public static void main(String[] args) {
    }
}
