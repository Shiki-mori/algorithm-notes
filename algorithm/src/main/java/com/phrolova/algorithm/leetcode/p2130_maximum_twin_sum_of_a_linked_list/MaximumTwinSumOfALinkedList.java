package com.phrolova.algorithm.leetcode.p2130_maximum_twin_sum_of_a_linked_list;

import com.phrolova.algorithm.leetcode.common.ListNode;

public class MaximumTwinSumOfALinkedList {
    public int pairSum(ListNode head) {
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

    public ListNode reverseList(ListNode head) {
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

    public static void main(String[] args) {
    }
}
