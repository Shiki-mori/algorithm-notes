package com.phrolova.algorithm.hot100.p0024_swap_nodes_in_pairs;

import com.phrolova.algorithm.hot100.common.ListNode;

public class SwapNodesInPairs {

    // 递归
    public ListNode swapPairsRecursion(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }

        ListNode newHead=head.next;
        head.next=swapPairs(newHead.next);
        newHead.next=head;
        return newHead;
    }

    // 迭代
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        // curr表示当前到达的节点
        ListNode curr = dummy;
        // 每次需要交换curr后面的两个节点

        // curr->first->second->
        // curr->second->first->
        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = curr.next.next;

            curr.next = second;
            first.next = second.next;
            second.next = first;

            curr = first;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
    }
}
