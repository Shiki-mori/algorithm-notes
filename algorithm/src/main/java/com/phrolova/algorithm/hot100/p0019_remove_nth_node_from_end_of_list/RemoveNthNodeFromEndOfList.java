package com.phrolova.algorithm.hot100.p0019_remove_nth_node_from_end_of_list;

import com.phrolova.algorithm.hot100.common.ListNode;

public class RemoveNthNodeFromEndOfList {

    // 两次遍历
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        ListNode current = dummy;

        for (int i = 1; i < length - n + 1; i++) {
            current = current.next;
        }

        current.next = current.next.next;

        ListNode ans = dummy.next;
        return ans;
    }

    // -------------------------------------------
    // 双指针

    public ListNode removeNthFromEnd2Points(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);

        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 1; i < n + 1; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        ListNode ans = dummy.next;
        return ans;
    }

    public static void main(String[] args) {
    }
}
