---
name: acm-mode-solution
description: Converts an existing LeetCode Java solution into ACM written-test form that reads stdin and writes stdout, as Main.java in the same problem directory. Use when the user asks for ACM mode, ACM 笔试, 笔试输入输出, 自行处理输入输出, or Main.java for a problem under algorithm/src/main/java/com/phrolova/algorithm/leetcode.
---

# ACM 模式笔试代码

由于部分公司的笔试为ACM模式，因此用户需要练习ACM模式的笔试题。即需要自行处理输入和输出。当用户要求为对应题目提供ACM模式代码时，将已有的代码在同级目录下新增文件 Main.java，改写为ACM笔试代码形式。

本 skill 只改写 ACM 代码，不改原题解文件，不补 `Problem.md` / `Solution.md`，除非用户另外要求。

## 适用范围

仅处理 `algorithm/src/main/java/com/phrolova/algorithm/leetcode/` 下的题目目录（`pXXXX_slug/`）。

- 目标不在该目录：一句话说明范围后停止。
- `leetcode/common/` 不是题目，不要当题改写。
- 不要改 `algorithm/src/main/java/com/phrolova/algorithm/Main.java`。

## 工作流程

1. **锁定题目**：用户说的题号、题名、当前文件/目录。目标不清时只问一句。
2. **读材料**（按存在情况，缺了就跳过）
   - 同目录 Java 解法类：算法主体
   - `Problem.md`：题意、示例输入输出、约束
   - `Solution.md`：多解法时用来选主推解
3. **选定解法**：用户点名则用点名的；否则用主推/默认那一版。不要把多种解法都塞进 `Main.java`。
4. **设计 ACM 输入输出**：把 LeetCode 函数签名改成 stdin / stdout。格式约定见下方。必须在 `Main.java` 顶部注释写出与 LeetCode 示例对应的一份样例输入和输出。
5. **新增文件**：在题目同级目录创建 `Main.java`。已有则覆盖更新，不要另起文件名。
6. **保持原文件不动**：不要改原解法类、`Problem.md`、`Solution.md`。

## 文件约定

- 路径：与原解法类同目录，例如 `.../p0001_two_sum/Main.java`
- `package` 与该目录其他 Java 文件一致
- 顶层类名必须是 `Main`，入口为 `public static void main(String[] args)`
- 算法与辅助结构（`ListNode`、`TreeNode`、Trie 等）写成 `Main` 的 `static` 内部类，不要 `import` `leetcode.common`，保证单文件可复制到笔试环境
- 快读快写：`BufferedReader` + `StringTokenizer` + `PrintWriter`，结束前 `out.flush()`
- 输出用 ACM 风格：空格分隔、逐行 `println`。不要 `Arrays.toString` 那种带括号的调试格式

## 输入输出约定

按题意从 `Problem.md` 示例反推一套自洽格式，并在注释里写死。默认单组数据；用户明确要求多组时，第一行读测试组数 `T` 再循环。

| 原题类型 | 推荐输入 | 推荐输出 |
| --- | --- | --- |
| 数组 + 若干标量 | 第一行 `n`，第二行 `n` 个整数，随后各标量一行 | 按返回值打印；数组空格分隔 |
| 字符串 | 每行一个字符串 | 按返回值打印 |
| 链表 | 第一行 `n`，第二行 `n` 个结点值 | 空格分隔结点值；空链表打印空行 |
| 二叉树 | 第一行层序结点数 `n`（含 `null`），第二行 `n` 个值，空结点写 `null` | 按返回值打印；若返回树则同样层序输出 |
| 设计类（Trie 等） | 第一行操作数 `n`，随后每行 `操作名 [参数...]` | 每操作一行；`void` 打 `null`，布尔打 `true`/`false` |

约束较大（如 `n` 到 `1e5`、操作到 `1e4`）时必须快 I/O，避免 `Scanner`。

## 模板

```java
package com.phrolova.algorithm.leetcode.pXXXX_slug;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * ACM 笔试输入（对应 LeetCode 示例）：
 *
 * <样例输入>
 *
 * ACM 笔试输出：
 *
 * <样例输出>
 */
public class Main {

    static class Solver {
        // 从原解法迁入的算法
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        // 读入 -> 调用 Solver -> 输出

        out.flush();
    }
}
```

函数题把原方法放进 `Solver`；设计题把原类改成 `static class`（见同目录已有的 `p0208_implement_trie_prefix_tree/Main.java`）。

## 约束

- 用中文短句回复：说明生成了哪个 `Main.java`、选了哪版解法、输入输出格式是什么。
- 不要在回复里贴出整份 `Main.java`，除非用户要贴代码。
- 原解法有本地 `main` 测试的，不要把它的硬编码用例原样搬进 ACM 版；ACM 版只从 stdin 读。
