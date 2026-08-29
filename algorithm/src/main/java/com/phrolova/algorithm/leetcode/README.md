# LeetCode 刷题记录

按题号组织，每题一个子包，三件套：`Problem.md`（题目描述）、`Solution.md`（题解）、Java 类（代码）。

## 命名约定

| 项 | 规则 | 示例 |
| --- | --- | --- |
| 子包名 | `p` + 四位题号 + `_` + slug（小写+下划线） | `p0001_two_sum` |
| 包声明 | `com.phrolova.algorithm.leetcode.<子包名>` | `...leetcode.p0001_two_sum` |
| 题目描述 | 固定为 `Problem.md` | — |
| 题解 | 固定为 `Solution.md` | — |
| 代码类 | PascalCase，与题名对应 | `TwoSum.java` |

题型、难度写在 `Problem.md` 头部元信息，不另建题型目录。

## 新增一题

1. 复制 `p0001_two_sum` 为 `p0xxx_slug`
2. 修改包名与 Java 类名
3. 填写 `Problem.md`、`Solution.md` 与代码
4. 在下方索引表追加一行

## 索引

| 题号 | 题名 | 目录 |
| --- | --- | --- |
| 1 | Two Sum | [p0001_two_sum](p0001_two_sum/) |
| 1768 | Merge Strings Alternately | [p1768_merge_strings_alternately](p1768_merge_strings_alternately/) |
