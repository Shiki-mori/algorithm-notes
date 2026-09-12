# 笔试复盘

笔试中遇到的题目。每题一个子包，三件套：`Problem.md`（题目描述）、`Solution.md`（复盘题解）、Java 类（代码）。笔试为 ACM 模式时，同目录可另放 `Main.java`。

## 命名约定

| 项 | 规则 | 示例 |
| --- | --- | --- |
| 子包名 | 公司 + `_` + slug（小写+下划线）；同公司同题加日期 | `meituan_max_subarray` |
| 包声明 | `com.phrolova.algorithm.exam.<子包名>` | `...exam.meituan_max_subarray` |
| 题目描述 | 固定为 `Problem.md` | — |
| 复盘题解 | 固定为 `Solution.md` | — |
| 代码类 | PascalCase，与题名对应 | `MaxSubarray.java` |

公司、日期、题型写在 `Problem.md` 头部元信息，不另建公司或题型目录。

公共类型可复用 [`../leetcode/common/`](../leetcode/common/)。

## 新增一题

1. 新建子包 `{公司}_{slug}`
2. 填写包名与 Java 类名
3. 填写 `Problem.md`、`Solution.md` 与代码
4. 在下方索引表追加一行

## 索引

| 公司 | 题名 | 目录 |
| --- | --- | --- |
| 途游 | 最少回合击败所有敌人 | [tuyoo_min_turns_defeat_camps](tuyoo_min_turns_defeat_camps/) |
