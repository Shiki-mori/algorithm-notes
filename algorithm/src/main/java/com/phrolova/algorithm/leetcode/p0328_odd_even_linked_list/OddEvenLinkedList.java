package com.phrolova.algorithm.leetcode.p0328_odd_even_linked_list;

import com.phrolova.algorithm.leetcode.common.ListNode;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        ListNode odd = head; // 奇
        ListNode even = head.next; // 偶
        ListNode preodd = odd;
        ListNode even0 = head.next;
        while (odd != null && even != null) {
            odd.next = even.next;
            preodd = odd;
            odd = odd.next;
            if (odd == null) {
                preodd.next = even0;
                return head;
            }
            even.next = odd.next;
            even = even.next;
            if (even == null) {
                odd.next = even0;
                return head;
            }
        }

        return head;
    }

    // -------------------------------------
    // official

    public ListNode oddEvenListOffcial(ListNode head) {
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

    public static void main(String[] args) {
    }
}
