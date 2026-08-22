# 归并排序

## 思想

分治：先拆成有序的小段，再把有序小段两两合并成更大的有序段。

1. **分解**：把数组从中间切开，左右各排一次。切到只剩 1 个元素时，这段已经有序。
2. **合并**：左右两段都有序后，用双指针把它们合成一段有序数组。

合并时准备一块辅助空间。左段指针 `i`、右段指针 `j`，谁小取谁，取完指针后移；某一段取完后，把另一段剩下的直接接上。

```text
左：1, 4, 7
右：2, 3, 8

1 < 2 → 取 1
4 > 2 → 取 2
4 > 3 → 取 3
4 < 8 → 取 4
7 < 8 → 取 7
右段空 → 接上 8

结果：1, 2, 3, 4, 7, 8
```

相等时取左边，保证稳定性。

整段排序的递归结构是：

```text
sort(L..R)
    mid = (L+R)/2
    sort(L..mid)
    sort(mid+1..R)
    merge(L..mid, mid+1..R)
```

用主定理：`T(N) = 2*T(N/2)+O(N)`，`a=2,b=2,d=1`，所以 `T(N)=O(N log N)`。

## 举例

对 `[4, 1, 7, 3]` 排序。

先一路对半切开，直到每段只剩一个元素：

```text
            [4, 1, 7, 3]
           /             \
       [4, 1]           [7, 3]
       /    \           /    \
     [4]    [1]       [7]    [3]
```

再自底向上合并：

```text
[4] 与 [1] 合并 → [1, 4]
[7] 与 [3] 合并 → [3, 7]

[1, 4] 与 [3, 7] 合并：
  1 < 3 → 取 1
  4 > 3 → 取 3
  4 < 7 → 取 4
  左段空 → 接上 7
→ [1, 3, 4, 7]
```

全过程：

```text
[4, 1, 7, 3]
    ↓ 分解
[4, 1]     [7, 3]
    ↓ 分解
[4] [1]   [7] [3]
    ↓ 合并
[1, 4]     [3, 7]
    ↓ 合并
[1, 3, 4, 7]
```

## 复杂度

时间复杂度：O(n log n)（最好、最坏、平均都是）  
空间复杂度：O(n)（辅助数组）  
稳定

## 初版代码（多处错误）

```java
package com.phrolova.algorithm.sorting.nlogn;

public class MergeSort {
    public static void mergeSort(int[] arr) {

        if (arr == null || arr.length < 2)
            return;
        sort(arr, 0, arr.length - 1);
    }

    public static int[] sort(int[] arr, int L, int R) {

        if (R - L < 1)
            return arr;

        int mid = L + (R - L) / 2;
        int[] left = sort(arr,L, mid);
        int[] right = sort(arr,mid + 1, R);
        return merge(left, right);
    }

    public static int[] merge(int[] L, int[] R) {
        int p1 = 0;
        int p2 = 0;
        int[] target = new int[L.length + R.length - 2];
        for (int i = 0; p1 < L.length && p2 < R.length; i++) {
            if (L[p1] <= R[p2]) {
                target[i] = L[p1];
                p1++;
            } else {
                target[i] = R[p2];
                p2++;
            }
        }
        return target;
    }
}
```

## 初版正确代码

```java
package com.phrolova.algorithm.sorting.nlogn;

public class MergeSort {
    public static void mergeSort(int[] arr) {

        if (arr == null || arr.length < 2) return;
        int[] sorted = sort(arr, 0, arr.length - 1);
        System.arraycopy(sorted, 0, arr, 0, sorted.length);

    }

    public static int[] sort(int[] arr, int L, int R) {

        if (R - L < 1) return new int[]{arr[L]};

        int mid = L + (R - L) / 2;
        int[] left = sort(arr, L, mid);
        int[] right = sort(arr, mid + 1, R);
        return merge(left, right);
    }

    public static int[] merge(int[] L, int[] R) {
        int p1 = 0;
        int p2 = 0;
        int i = 0;
        int[] target = new int[L.length + R.length];
        while (p1 < L.length && p2 < R.length) {
            if (L[p1] <= R[p2]) {
                target[i++] = L[p1++];
            } else {
                target[i++] = R[p2++];
            }
        }
        while (p1 < L.length) {
            target[i++] = L[p1++];
        }
        while (p2 < R.length) {
            target[i++] = R[p2++];
        }
        return target;
    }
}
```