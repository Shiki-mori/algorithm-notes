package com.phrolova.algorithm.hot100.p0160_intersection_of_two_linked_lists;

import com.phrolova.algorithm.hot100.common.ListNode;

public class IntersectionOfTwoLinkedLists {

    // -----------------------------------
    // HashSet

    public ListNode getIntersectionNodeSet(ListNode headA, ListNode headB) {

        Set<ListNode> setA=new HashSet<>();

        while(headA!=null){
            setA.add(headA);
            headA=headA.next;
        }

        while(headB!=null){
            if(setA.contains(headB)){
                return headB;
            }
            headB=headB.next;
        }
        
        return null;
    }

    // ------------------------------------
    // 双指针
    public ListNode getIntersectionNode2Points(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            if (pA == null) {
                pA = headB;
            } else {
                pA = pA.next;
            }

            if (pB == null) {
                pB = headA;
            } else {
                pB = pB.next;
            }
        }

        return pA;
    }

    // -------------------------------------
    // 长度差

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp = headA;

        int lengthA = 0;
        int lengthB = 0;
        while (temp != null) {
            temp = temp.next;
            lengthA++;
        }
        temp = headB;
        while (temp != null) {
            temp = temp.next;
            lengthB++;
        }

        ListNode temp2 = null;
        int lenTemp = 0;
        boolean longer = lengthA > lengthB;
        if (longer) {
            temp = headA;
            temp2 = headB;
            lenTemp = lengthA - lengthB;
        } else {
            temp = headB;
            temp2 = headA;
            lenTemp = lengthB - lengthA;
        }

        for (int i = 0; i < lenTemp; i++) {
            temp = temp.next;
        }

        while (temp != temp2) {
            temp = temp.next;
            temp2 = temp2.next;
        }

        return temp;
    }

    public static void main(String[] args) {
    }
}
