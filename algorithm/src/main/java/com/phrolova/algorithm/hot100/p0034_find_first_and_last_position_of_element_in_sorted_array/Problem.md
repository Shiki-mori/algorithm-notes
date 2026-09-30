# 34. Find First and Last Position of Element in Sorted Array

- 难度：Medium
- 标签：Array, Binary Search
- 链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/

## 题目描述

给你一个按照非递减顺序排列的整数数组 `nums`，和一个目标值 `target`。请你找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 `target`，返回 `[-1, -1]`。

你必须设计并实现时间复杂度为 `O(log n)` 的算法解决此问题。

## 示例

**示例 1：**

```text

输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]
```

**示例 2：**

```text

输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]
```

**示例 3：**

```text

输入：nums = [], target = 0
输出：[-1,-1]
```

## 约束

- `0 <= nums.length <= 105`
- `-109 <= nums[i] <= 109`
- `nums` 是一个非递减数组
- `-109 <= target <= 109`
