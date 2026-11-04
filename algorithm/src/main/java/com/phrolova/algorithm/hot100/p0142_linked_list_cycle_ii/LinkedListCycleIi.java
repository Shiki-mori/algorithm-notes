package com.phrolova.algorithm.hot100.p0142_linked_list_cycle_ii;

import com.phrolova.algorithm.hot100.common.ListNode;

public class LinkedListCycleIi {

    // 哈希表
    public ListNode detectCycleHashSet(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<ListNode>();

        while (pos != null) {
            if (!visited.add(pos)) {
                return pos;
            }
            pos = pos.next;
        }

        return null;
    }
    
    // --------------------------------------
    // 快慢指针
    
    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        boolean result = false;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                result = true;
                break;
            }
        }

        if (!result) {
            return null;
        }

        ListNode ans = head;
        while (ans != slow) {
            ans = ans.next;
            slow = slow.next;
        }

        return ans;
    }

    public static void main(String[] args) {
    }
}
