# 84. Largest Rectangle in Histogram

- 难度：Hard
- 标签：Stack, Array, Monotonic Stack
- 链接：https://leetcode.cn/problems/largest-rectangle-in-histogram/

## 题目描述

给定 *n* 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。

## 示例

**示例 1:**

```text

输入：heights = [2,1,5,6,2,3]
输出：10
解释：最大的矩形为图中红色区域，面积为 10

```

**示例 2：**

```text

输入： heights = [2,4]
输出： 4
```

## 约束

- `1 <= heights.length <=105`
- `0 <= heights[i] <= 104`
