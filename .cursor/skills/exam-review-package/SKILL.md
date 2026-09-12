---
name: exam-review-package
description: Creates a written-exam review package under algorithm/src/main/java/com/phrolova/algorithm/exam when the user recounts a problem from a company written test. Use when the user describes a 笔试题目 they encountered, 笔试中遇到, 笔试复盘, OA, or asks to record an exam problem.
---

# 笔试题目建包

当用户说明自己在笔试中遇到的题目时，你需要建好对应的包。

本 skill 只在 `algorithm/src/main/java/com/phrolova/algorithm/exam/` 下建题，不改 `leetcode/`、不写 ACM `Main.java`，除非用户另外要求。约定以同目录 [README.md](../../../algorithm/src/main/java/com/phrolova/algorithm/exam/README.md) 为准。

先判断任务类型：

- **建包**：用户在说笔试里遇到的某道题（题意、输入输出、公司、现场回忆），或要求记录/复盘/建包。立即建子包。
- **补全**：目标子包已存在。只补缺失文件，禁止覆盖已有 `Problem.md` / `Solution.md` / Java 类。
- **不是本 skill**：LeetCode 题要 ACM `Main.java`、掌握度评估、或只讨论策略不描述具体题。不要建 `exam` 包。

## 工作流程

1. **锁定题目**：公司、题名或题意。缺公司或无法命名时只问一句，不要连续追问。
2. **命名**：子包 `{公司}_{slug}`（小写+下划线）。slug 从题名或题意抽 2–5 个英文词。同公司同题已存在则加日期，如 `meituan_20260912_max_subarray`。不另建公司或题型目录。
3. **查重**：先看 `exam/` 下是否已有同名或明显同一题。已有则走补全，并在回复里说明路径。
4. **建文件**（缺了才建）：
   - `Problem.md`：把用户说的题意、示例、约束写进去。没说的项留空，不要编造样例或数据范围。
   - `Solution.md`：只放题解骨架；用户没要求复盘/题解时不要写思路。
   - `{ClassName}.java`：包名与类名对齐，只放空类和空 `main`。用户没要求代码时不要写算法。
5. **索引**：在 `exam/README.md` 索引表追加一行。已有该行则不改。
6. **回复**：用中文短句说明建了哪个子包、写了哪些文件。缺的信息标出来。不要在回复里贴整份文件。

## 文件约定

| 项 | 规则 | 示例 |
| --- | --- | --- |
| 路径 | `.../exam/{公司}_{slug}/` | `.../exam/meituan_max_subarray/` |
| 包声明 | `com.phrolova.algorithm.exam.{公司}_{slug}` | `...exam.meituan_max_subarray` |
| 题目 | 固定 `Problem.md` | — |
| 题解 | 固定 `Solution.md` | — |
| 代码类 | PascalCase，与题名对应 | `MaxSubarray.java` |

公司、日期、题型写在 `Problem.md` 头部，不建子目录。公共类型复用 `leetcode/common/`，不要在 `exam/` 复制一份。

## 模板

`Problem.md`：

````markdown
# <题名>

- 公司：
- 日期：
- 题型：
- 链接：

## 题目描述

<用户转述的题意>

## 示例

```text
输入：
输出：
```

## 约束

-
````

`Solution.md`：

```markdown
# 题解：<题名>

## 思路

## 复杂度

- 时间：
- 空间：

## 关键点
```

Java：

```java
package com.phrolova.algorithm.exam.{company}_{slug};

public class ClassName {

    public static void main(String[] args) {
    }
}
```

## 约束

- 用中文短句。
- 用户只说明题目时：建包 + 填 `Problem.md` + 骨架文件 + 索引；不要顺手写题解或 AC 代码。
- 用户同时要求复盘/题解/代码时，可以在同一次把 `Solution.md` 和 Java 类写完。
- 禁止把笔试题放进 `leetcode/pXXXX_slug/`。
- 禁止为了对齐格式而虚构公司名、样例、约束或链接。
