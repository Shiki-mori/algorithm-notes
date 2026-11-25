package com.phrolova.algorithm.hot100.p0148_sort_list;

import com.phrolova.algorithm.hot100.common.ListNode;

public class SortList {
    // 自上而下归并：递归

    // 从中间断开链表
    public ListNode sortListRecursive(ListNode head) {
        // 0或1个节点，天然有序
        if (head == null || head.next == null) {
            return head;
        }

        // 寻找链表中点
        ListNode slow = head;
        ListNode fast = head.next;
        // slow最终停在前半段的尾节点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        /*
         *  1 2 3  4  5 6 (7)
         *  s s s (s)
         *    f    f    f     (f)
         */

        ListNode mid = slow.next;
        // 断开
        slow.next = null;

        return merge(sortListRecursive(head), sortListRecursive(mid));
    }

    // 合并两个有序链表
    public ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                tail.next = node1;
                node1 = node1.next;
            } else {
                tail.next = node2;
                node2 = node2.next;
            }
            tail = tail.next;
        }
        tail.next = node1 == null ? node2 : node1;
        return dummy.next;
    }

    // --------------------------------------------------------
    // 自下而上归并：迭代

    public ListNode sortList(ListNode head) {
        int n = 0;
        for (ListNode p = head; p != null; p = p.next) {
            n++;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        for (int size = 1; size < n; size *= 2) {
            ListNode tail = dummy;  // 已合并部分的尾节点
            ListNode cur = dummy.next;   // 待处理部分的头

            while (cur != null) {
                ListNode left = cur;
                ListNode right = cut(left, size);
                cur = cut(right, size);  // 记住剩余部分的头

                tail.next = merge(left, right);
                while (tail.next != null) {
                    tail = tail.next;
                }
            }
        }

        return dummy.next;
    }

    // 保留 head 开头的 size 个节点，断开并返回剩余部分的头
    private ListNode cut(ListNode head, int size) {
        for (int i = 1; i < size && head != null; i++) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode rest = head.next;
        head.next = null;
        return rest;
    }

    public static void main(String[] args) {
    }
}
