package com.phrolova.algorithm.leetcode.p2130_maximum_twin_sum_of_a_linked_list;

import java.util.*;
import java.io.*;



/**
 * ACM 笔试输入（对应 LeetCode 示例）：
 * 第一行 n（偶数，结点数）
 * 第二行 n 个结点值
 *
 * 4
 * 5 4 2 1
 *
 * ACM 笔试输出：
 * 一个整数，最大孪生和
 *
 * 6
 *
 * 另一组：
 *
 * 4
 * 4 2 2 3
 *
 * 输出：
 *
 * 7
 *
 * 另一组：
 *
 * 2
 * 1 100000
 *
 * 输出：
 *
 * 100001
 */
public class Main {
    // === 原代码（保留）===
    // public class ListNode {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val){
            this.val=val;
        }        
        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }

    public static int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 此时slow指向后半部分起始位置
        ListNode second = reverseList(slow);

        int maxValue = -Integer.MAX_VALUE;

        while (second != null) {
            maxValue = Math.max(maxValue, head.val + second.val);
            head = head.next;
            second = second.next;
        }

        return maxValue;

    }

    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);

        int n=Integer.parseInt(br.readLine().trim());

        // === 原代码（保留）===
        // StringTokenizer st=new StringTokenizer();
        StringTokenizer st=new StringTokenizer(br.readLine().trim());
        ListNode head=new ListNode(Integer.parseInt(st.nextToken()));
        ListNode prev=head;
        for(int i=1;i<n;i++){
            int val=Integer.parseInt(st.nextToken());
            ListNode node=new ListNode(val);
            prev.next=node;
            prev=node;
        }

        out.println(pairSum(head));
        out.flush();
    }
}