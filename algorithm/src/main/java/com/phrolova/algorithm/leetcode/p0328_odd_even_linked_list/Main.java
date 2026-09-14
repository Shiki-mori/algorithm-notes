package com.phrolova.algorithm.leetcode.p0328_odd_even_linked_list;

import java.util.*;
import java.io.*;

/**
 * ACM 笔试输入（对应 LeetCode 示例）：
 *
 * 5
 * 1 2 3 4 5
 *
 * ACM 笔试输出：
 *
 * 1 3 5 2 4
 *
 * 另一组：
 *
 * 7
 * 2 1 3 5 6 4 7
 *
 * 输出：
 *
 * 2 3 6 7 1 5 4
 *
 * 空链表：第一行 0，输出空行。
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        // === 原代码（保留）===
        // int n = Integer.parseInt(br.readLine());
        // StringTokenizer st = new StringTokenizer(br.readLine());
        //
        // ListNode list = new ListNode();
        // ListNode head = list;
        // for (int i = 0; i < n; i++) {
        //     list.val = Integer.parseInt(st.nextToken());
        //     list = list.next;
        // }
        //
        // head = oddEvenListOffcial(head);
        // for (int i = 0; i < n; i++) {
        //     out.print(head.val);
        //     head = head.next;
        // }
        // out.flush();

        int n = Integer.parseInt(br.readLine().trim());
        ListNode head = null;
        if (n > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ListNode dummy = new ListNode();
            ListNode cur = dummy;
            for (int i = 0; i < n; i++) {
                cur.next = new ListNode(Integer.parseInt(st.nextToken()));
                cur = cur.next;
            }
            head = dummy.next;
        }

        head = oddEvenListOffcial(head);
        if (head == null) {
            out.println();
        } else {
            while (head != null) {
                out.print(head.val);
                head = head.next;
                if (head != null) {
                    out.print(' ');
                }
            }
            out.println();
        }
        out.flush();
    }

    // === 原代码（保留）===
    // public class ListNode {
    //
    //     int val;
    //     ListNode next;
    //
    //     ListNode() {
    //     };
    //
    //     ListNode(int val, ListNode next) {
    //         this.val = val;
    //         this.next = next;
    //     }
    // }
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode oddEvenListOffcial(ListNode head) {
        if (head == null)
            return null;
        ListNode odd = head; // 奇
        ListNode even = head.next; // 偶
        ListNode even0 = head.next;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = even0;
        return head;
    }

}