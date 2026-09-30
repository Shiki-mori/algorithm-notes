# 438. Find All Anagrams in a String

- 难度：Medium
- 标签：Hash Table, String, Sliding Window
- 链接：https://leetcode.cn/problems/find-all-anagrams-in-a-string/

## 题目描述

给定两个字符串 `s` 和 `p`，找到 `s`中所有 `p`的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

## 示例

**示例 1:**

```text

输入: s = "cbaebabacd", p = "abc"
输出: [0,6]
解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。

```

 

**示例 2:**

```text

输入: s = "abab", p = "ab"
输出: [0,1,2]
解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。

```

## 约束

- `1 <= s.length, p.length <= 3 * 104`
- `s` 和 `p` 仅包含小写字母
