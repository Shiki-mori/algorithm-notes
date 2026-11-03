package com.phrolova.algorithm.hot100.p0234_palindrome_linked_list;

import com.phrolova.algorithm.hot100.common.ListNode;

public class PalindromeLinkedList {
    public boolean isPalindromeToArray(ListNode head) {
        List<Integer> vals = new ArrayList<>();

        // 将链表转为数组
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // 双指针
        int length = vals.size();
        int left = 0;
        int right = length - 1;

        while (left < right) {

            if (vals.get(left) != vals.get(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
    
    // -----------------------------------------
    // 反转后半段比较
    
    public boolean isPalindrome(ListNode head) {
        ListNode currentNode = head;

        ListNode fast = currentNode;
        ListNode slow = currentNode;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow.next 即为开始反转的节点

        ListNode reversedHead = reverseList(slow.next);
        ListNode p1 = head;
        ListNode p2 = reversedHead;
        boolean result = true;

        while (p2 != null) {
            if (p1.val != p2.val) {
                result = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        slow.next = reverseList(reversedHead);
        return result;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
    }
}
