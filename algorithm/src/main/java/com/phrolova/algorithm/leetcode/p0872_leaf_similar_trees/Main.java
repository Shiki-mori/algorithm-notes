package com.phrolova.algorithm.leetcode.p0872_leaf_similar_trees;

import java.util.*;
import java.io.*;

/**
 * ACM 笔试输入（对应 LeetCode 示例）：
 *
 * 11
 * 3 5 1 6 2 9 8 null null 7 4
 * 15
 * 3 5 1 6 7 4 2 null null null null null null 9 8
 *
 * ACM 笔试输出：
 *
 * true
 *
 * 示例 2 输入：
 * 3
 * 1 2 3
 * 3
 * 1 3 2
 * 输出：
 * false
 */

public class Main {

    public static void main(String[] args) throws IOException {
        // === 原代码（保留）===
        // BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        // PrintWriter out=new PrintWriter(System.out);
        //
        // Integer n1=Integer.parseInt(br.readLine());
        // StringTokenizer st1=new StringTokenizer(br.readLine());
        //
        // Integer n2=Integer.parseInt(br.readLine());
        // StringTokenizer st2=new StringTokenizer(br.readLine());
        //
        // TreeNode root1=new TreeNode();
        // TreeNode root2=new TreeNode();
        //
        // for(int i=0;i<n;i++){
        //     root1.val=Integer.parseInt(st1.nextToken());
        //     root1.left=new TreeNode();
        //     root1=root1.left;
        //     root1.right=new TreeNode();
        // }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n1 = Integer.parseInt(br.readLine().trim());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n2 = Integer.parseInt(br.readLine().trim());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        TreeNode root1 = buildTree(n1, st1);
        TreeNode root2 = buildTree(n2, st2);
        out.println(leafSimilar(root1, root2));
        out.flush();
    }

    /**
     * 层序建树：数组是 BFS 序列，空结点写 null，null 不再展开孩子。
     * 队列里只放「还缺左右孩子」的非空结点，每次取出一个父结点，
     * 按顺序消耗数组里接下来的 1~2 个值，分别挂成 left / right。
     */
    public static TreeNode buildTree(int n, StringTokenizer st) {
        if (n == 0) {
            return null;
        }
        String[] vals = new String[n];
        for (int i = 0; i < n; i++) {
            vals[i] = st.nextToken();
        }
        if ("null".equals(vals[0])) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < n) {
            TreeNode cur = q.poll();
            if (i < n) {
                String left = vals[i++];
                if (!"null".equals(left)) {
                    cur.left = new TreeNode(Integer.parseInt(left));
                    q.add(cur.left);
                }
            }
            if (i < n) {
                String right = vals[i++];
                if (!"null".equals(right)) {
                    cur.right = new TreeNode(Integer.parseInt(right));
                    q.add(cur.right);
                }
            }
        }
        return root;
    }

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){}

        TreeNode(int val){
            this.val=val;
        }

        TreeNode(int val,TreeNode left,TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();
        dfs(root1, r1);
        dfs(root2, r2);

        return r1.equals(r2);
    }

    public static void dfs(TreeNode root, List<Integer> r) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            r.add(root.val);
            return;
        }
        dfs(root.left, r);
        dfs(root.right, r);
    }
}