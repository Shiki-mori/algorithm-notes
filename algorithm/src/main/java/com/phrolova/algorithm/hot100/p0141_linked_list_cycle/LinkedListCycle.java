package com.phrolova.algorithm.hot100.p0141_linked_list_cycle;

import com.phrolova.algorithm.hot100.common.ListNode;

public class LinkedListCycle {

    // ------------------------------------
    // 哈希表遍历
    public boolean hasCycleHashSet(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
    
    // ---------------------------------------
    // 快慢指针
    
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        if (head == null) {
            return false;
        }

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
    }
}
