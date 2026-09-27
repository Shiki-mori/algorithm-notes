# 题解：Decode String

## 思路

用 `LinkedList<String>` 当栈，从左到右扫 `s`。栈里只放字符串：完整数字、单个字母、`[`，以及已经按次数展开好的片段。`]` 本身不入栈，它只表示「当前这一层可以展开了」。

外层循环用 `ptr` 指向还没处理的字符。三个分支各自把指针往后挪：

- 数字：`getDigits` 一边读一边 `ptr++`，拼出完整数字再入栈。
- 字母或 `[`：`charAt(ptr++)` 取出这个字符并后移，转成字符串后入栈。
- `]`：单独 `ptr++` 跳过它，然后弹栈展开。

### `ptr++`：跳过当前的 `]`

```java
} else {
    ptr++;
```

走到这个 `else` 时，`cur` 已经是 `]`。它不入栈。接下来从栈顶往下弹，直到弹出的序列里出现 `[`，把括号里的内容拼好、按次数重复，再压回栈。

这里的 `ptr++` 只负责离开当前这个 `]`，下一轮从它右边的字符继续。少了这一步，`ptr` 会停在同一个 `]` 上，`while (ptr < s.length())` 不会结束。

### `String.valueOf`：把 `char` 变成 `String`

```java
stack.addLast(String.valueOf(s.charAt(ptr++)));
```

`s.charAt(...)` 返回的是 `char`。栈的类型是 `LinkedList<String>`，`addLast` 只能接收 `String`。`String.valueOf(char)` 得到长度为 1 的字符串，例如 `'a'` 变成 `"a"`，`'['` 变成 `"["`。

后面用 `"[".equals(stack.peekLast())` 找左括号，`getString` 也是按 `String` 拼接，所以字母和 `[` 都要先变成字符串再入栈。同一次调用里的 `ptr++` 是读完这个字符后把指针后移。

### `t.toString()`：把 `StringBuilder` 变成 `String` 再入栈

```java
StringBuilder t = new StringBuilder();
while (repTime-- > 0) {
    t.append(o);
}
stack.addLast(t.toString());
```

`t` 用来把括号内的片段重复 `repTime` 次。`StringBuilder` 不是 `String`，不能直接 `stack.addLast(t)`，编译会报类型不匹配。

`t.toString()` 把已经拼好的内容变成一个普通字符串再压回栈。之后它和之前入栈的字母片段一样，外层再遇到 `]` 时可以被弹出、拼接、继续重复。

## 复杂度

- 时间：O(n + S)。n 是原串长度，S 是解码后的长度。原串扫一遍；每一层展开复制的字符数按重复次数成倍增长，各层加起来与 S 同阶。
- 空间：O(n + S)。栈上保存尚未合并的片段，以及展开后的字符串。

## 关键点

- 栈里只有 `String`。数字、字母、`[` 和展开结果都是字符串，`]` 不入栈。
- 字母和 `[` 用 `String.valueOf` 把 `char` 收成单字符字符串；展开结果用 `toString()` 把 `StringBuilder` 收成 `String`。
- 三个分支都要推进 `ptr`。`]` 分支里的 `ptr++` 只跳过右括号，否则指针停住，循环不会结束。
