# 题解：Reverse Words in a String

## 思路

先去掉首尾空白，再按空白把句子拆成单词列表，反转后用单个空格拼回去。

核心一句：

```java
List<String> wordList = Arrays.asList(s.split("\\s+"));
```

从里到外看：

1. `s.split("\\s+")` 用正则把 `s` 切开，得到 `String[]`。
   - `\s`：任意空白（空格、制表符、换行等）
   - `+`：连续 1 个或多个
   - 写成 `"\\s+"`：Java 字符串里 `\` 要再转义一次

   连续空格会被当成一个分隔符，不会留下空字符串。例如：

   ```text
   "the sky is blue"   →  ["the", "sky", "is", "blue"]
   "hello   world"     →  ["hello", "world"]
   ```

   前面已经 `trim()` 过，开头和结尾的空白也去掉了。

2. `Arrays.asList(...)` 把这个数组转成 `List<String>`，方便后面用 `Collections.reverse(wordList)` 原地反转。

`Arrays.asList` 得到的是固定长度列表，不能 `add`/`remove`，但可以改元素顺序，所以这里反转没问题。

整句合起来就是：按空白把句子拆成单词，放进一个可反转的列表。

### 示例

以 `s = "a good   example"` 为例（已 `trim()`，首尾无空白）：

```text
s.split("\\s+")
  →  String[] { "a", "good", "example" }

Arrays.asList(...)
  →  List ["a", "good", "example"]
```

中间三个空格被 `"\\s+"` 一次吃掉，没有空串。后面 `Collections.reverse` 得到 `["example", "good", "a"]`，`String.join(" ", ...)` 得到 `"example good a"`。

若输入是 `"  hello world  "`：

```text
trim()                          →  "hello world"
split("\\s+") + Arrays.asList   →  ["hello", "world"]
```

## 复杂度

- 时间：O(n)，扫描一遍字符串做拆分、反转、拼接
- 空间：O(n)，单词列表和结果字符串

## 关键点

- 必须先 `trim()`，否则 `"  hello world  ".split("\\s+")` 会在两端留下空串。
- `"\\s+"` 一次吃掉连续空白，中间多个空格不会变成空单词。
- `Arrays.asList` 不能增删元素，但 `Collections.reverse` 只改顺序，可以安全使用。
