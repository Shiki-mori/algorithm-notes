# 题解：Construct Binary Tree from Preorder and Inorder Traversal

## 思路

递归

index：    0 1 2 3 4

preorder： 3 9 2 5 7

inorder：  9 3 5 2 7

3为根，k=1

左子树：

inLeft，inRight：0，0

preLeft，preRight：1，1

右子树：

inLeft，inRight：2，4

preLeft，preRight：2，4

1. 取preorder的第一个元素作为根
2. 在inorder中找到根的位置k，左边 k-inLeft 个元素属于左子树，记为 leftSize
3. 在preorder里切出左右子树的区间：
   - 左子树：前序 [preLeft+1, preLeft+leftSize]，中序 [inLeft, k-1]
   - 右子树：前序 [preLeft+leftSize+1, preRight]，中序 [k+1,inRight]
4. 递归

如果每次线性扫描寻找根，最坏是O(n^2)。

题目保证元素互不重复，可先用哈希表存好“值->中序下标”，每次O(1)找到根。


inLeft，inRight：当前子树在inorder中的下标范围

preLeft，preRight：当前子树在preorder中的下标范围

## 复杂度

- 时间：
- 空间：

## 关键点
