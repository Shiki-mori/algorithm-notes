package com.phrolova.algorithm.leetcode.p2095_delete_the_middle_node_of_a_linked_list;

import com.phrolova.algorithm.leetcode.common.ListNode;

public class DeleteTheMiddleNodeOfALinkedList {
    public ListNode deleteMiddle(ListNode head) {

        if (head.next == null)
            return null;

        ListNode fast = head.next.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    // -----------------------------------------
    // 维护slow前驱节点

    public ListNode deleteMiddleMaintainPre(ListNode head) {

        if (head.next == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = slow;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }

        pre.next = pre.next.next;
        return head;
    }

    public static void main(String[] args) {
    }
}
