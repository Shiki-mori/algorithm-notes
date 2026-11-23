package com.phrolova.algorithm.hot100.p0138_copy_list_with_random_pointer;

import java.util.HashMap;
import java.util.Map;
import java.util.prefs.NodeChangeEvent;

import com.phrolova.algorithm.hot100.common.Node;

public class CopyListWithRandomPointer {

    // 两次遍历
    public Node copyRandomList1(Node head) {
        // 存储旧节点->新节点之间的映射关系
        Map<Node, Node> map = new HashMap<>();

        // 建节点+建表
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            map.put(cur, node);
            cur = cur.next;
        }

        // 根据表，连接每个节点的next和random
        cur = head;
        while (cur != null) {
            // map.get(cur) 即为 cur 对应的新节点
            Node newNode = map.get(cur);
            newNode.next = map.get(cur.next);
            newNode.random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }

    // 递归

    private final Map<Node, Node> map = new HashMap<>();

    public Node copyRandomListRecursive(Node head) {
        if (head == null) {
            return null;
        }

        // 已经复制过：直接返回已有节点
        if (map.containsKey(head)) {
            return map.get(head);
        }

        // 未复制过

        // 建立新节点，存到map
        Node copy = new Node(head.val);
        map.put(head, copy);

        // 递归复制 next 和 random
        copy.next = copyRandomListRecursive(head.next);
        copy.random = copyRandomListRecursive(head.random);

        return copy;
    }

    // 原地交错拼接

    public Node copyRandomList3(Node head) {
        if (head == null) {
            return null;
        }

        // 在每个节点后插入拷贝
        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = cur.next.next;
        }

        // 设置新节点的random
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                // cur.next.random 是cur对应的新节点的random
                // cur.random.next 是cur的random对应的新节点

                // 若cur.random为null，null.next 会空指针
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // 将交错拼接的链表拆分为两条链表
        Node newHead = head.next;
        cur = head;
        while (cur != null) {
            Node copy = cur.next;
            cur.next = copy.next;
            copy.next = (copy.next == null) ? null : copy.next.next;

            cur=cur.next;
        }

        return newHead;
    }

    public static void main(String[] args) {
    }
}
