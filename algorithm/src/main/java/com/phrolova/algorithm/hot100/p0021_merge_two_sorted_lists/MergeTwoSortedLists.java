package com.phrolova.algorithm.hot100.p0021_merge_two_sorted_lists;

import com.phrolova.algorithm.hot100.common.ListNode;

public class MergeTwoSortedLists {

    // 递归
    public ListNode mergeTwoListsRecursion(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = mergeTwoListsRecursion(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRecursion(list2.next, list1);
            return list2;
        }
    }

    // -------------------------------------------
    // 迭代

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode preHead = new ListNode(-1);

        ListNode prev = preHead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
                prev = prev.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
                prev = prev.next;
            }
        }

        if (list1 == null) {
            prev.next = list2;
        } else {
            prev.next = list1;
        }

        return preHead.next;
    }

    public static void main(String[] args) {
    }
}
