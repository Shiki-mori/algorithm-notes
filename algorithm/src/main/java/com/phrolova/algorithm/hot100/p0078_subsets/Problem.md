# 78. Subsets

- 难度：Medium
- 标签：Bit Manipulation, Array, Backtracking
- 链接：https://leetcode.cn/problems/subsets/

## 题目描述

给你一个整数数组 `nums` ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

## 示例

**示例 1：**

```text

输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

```

**示例 2：**

```text

输入：nums = [0]
输出：[[],[0]]

```

## 约束

- `1 <= nums.length <= 10`
- `-10 <= nums[i] <= 10`
- `nums` 中的所有元素 互不相同
