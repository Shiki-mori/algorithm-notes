# 148. Sort List

- 难度：Medium
- 标签：Linked List, Two Pointers, Divide and Conquer, Sorting, Merge Sort
- 链接：https://leetcode.cn/problems/sort-list/

## 题目描述

给你链表的头结点 `head` ，请将其按 升序 排列并返回 排序后的链表 。

## 示例

**示例 1：**

```text

输入：head = [4,2,1,3]
输出：[1,2,3,4]

```

**示例 2：**

```text

输入：head = [-1,5,3,4,0]
输出：[-1,0,3,4,5]

```

**示例 3：**

```text

输入：head = []
输出：[]

```

## 约束

- 链表中节点的数目在范围 `[0, 5 * 104]` 内
- `-105 <= Node.val <= 105`
- 进阶：你可以在 `O(n log n)` 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
