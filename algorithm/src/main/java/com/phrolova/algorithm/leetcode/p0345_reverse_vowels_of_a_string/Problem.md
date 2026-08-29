# 345. Reverse Vowels of a String

- 难度：Easy
- 标签：Two Pointers, String
- 链接：https://leetcode.cn/problems/reverse-vowels-of-a-string/

## 题目描述

给你一个字符串 `s` ，仅反转字符串中的所有元音字母，并返回结果字符串。

元音字母包括 `'a'`、`'e'`、`'i'`、`'o'`、`'u'`，且可能以大小写两种形式出现不止一次。

## 示例

**示例 1：**

输入：s = "IceCreAm"

输出："AceCreIm"

解释：

`s` 中的元音是 `['I', 'e', 'e', 'A']`。反转这些元音，`s` 变为 `"AceCreIm"`.

**示例 2：**

输入：s = "leetcode"

输出："leotcede"

## 约束

- `1 <= s.length <= 3 * 105`
- `s` 由 可打印的 ASCII 字符组成
