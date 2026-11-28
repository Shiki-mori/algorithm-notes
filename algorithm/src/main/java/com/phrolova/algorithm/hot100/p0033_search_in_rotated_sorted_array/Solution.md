# 题解：Search in Rotated Sorted Array

## 思路

旋转后的数组是两段递增数组拼接起来的。以 [4,5,6,7,0,1,2] 为例：

```
大段 [4,5,6,7]  |  小段 [0,1,2]
                  ↑ 最小值，即旋转点
```

两个事实：

- 大段的每个数都比小段的每个数大
- 每段内部递增

分两步：

1. 二分找旋转点，即最小值的下标 k
2. 按 target 落在哪一段，在 [k, n-1] 或 [0, k-1] 上普通二分

#### 第一步：二分找旋转点

每次取 mid，只回答一个问题：mid 在大段还是小段？

- 在大段：最小值一定在 mid 右边，left=mid+1
- 在小段：最小值是 mid 本身或在它左边，right=mid

判断方法是 nums[mid] 和 nums[right] 比较：

- nums[mid]>nums[right]：left=mid+1
- 否则：right=mid

循环条件用 left<right，结束时 left==right 就是 k。

#### 为什么和 nums[right] 比较

nums[right] 是区间最后一个数，总在小段里。区间没旋转时，把整个区间看成小段。

- nums[mid]>nums[right]：小段内部递增，没有比 nums[right] 更大的数，mid 只能在大段
- nums[mid]<=nums[right]：大段的数都比 nums[right] 大，mid 只能在小段

两种结果各自只对应一种情况，没有歧义。

没旋转的 [1,2,3,4,5]：

- left=0，right=4，mid=2，3>5 不成立，right=2
- left=0，right=2，mid=1，2>3 不成立，right=1
- left=0，right=1，mid=0，1>2 不成立，right=0
- left==right==0，返回 0，正确

#### 为什么不能和 nums[left] 比较（错误）

改成「nums[mid]>nums[left] 就 left=mid+1」。nums[mid]>nums[left] 成立时有两种可能：

1. 区间有旋转，left 和 mid 都在大段：最小值在右边，应往右
2. 区间没旋转，整段递增：最小值就是 nums[left]，应往左收

只看这一次比较分不清是哪种，规则只能选一个方向，必然有一种情况走错。

在 [1,2,3,4,5] 上（情况 2，最小值在下标 0）：

- left=0，right=4，mid=2，3>1，left=3。最小值已经被丢掉
- left=3，right=4，mid=3，4>4 不成立，right=3
- left==right==3，返回 3，值是 4，错误

注意 mid 可能等于 left，这时两者相等、条件不成立，所以 left 不一定被推到末尾。但只要往右走过了头，最小值就丢了。

#### 为什么用 left<right

有 right=mid 这一步，right 不排除 mid。若用 left<=right，left==right 时 mid==right，nums[mid]>nums[right] 不成立，执行 right=mid，区间不变，死循环。

区间只剩一个元素时，它就是最小值，不用再判断。

#### 第二步：在对应的一段里二分

- nums[k]<=target<=nums[n-1]：在 [k, n-1] 里找
- 否则：在 [0, k-1] 里找

数组没旋转时 k=0，[0, -1] 是空区间，循环不进，返回 -1，不用特殊处理。

#### 「重新拼接」不需要真的拼

拼出新数组是 O(n)。和 74 题二维下标转一维一样，用下标映射：逻辑有序数组的第 i 个元素是 nums[(i+k)%n]，在 [0, n-1] 上普通二分即可。

#### 另一种思路：一次二分

不找旋转点。取 mid 后，[left, mid] 和 [mid, right] 至少有一半有序：

- nums[left]<=nums[mid]：左半有序。target 在 [nums[left], nums[mid]) 里就往左，否则往右
- 否则右半有序。target 在 (nums[mid], nums[right]] 里就往右，否则往左

代码更短，但 < 和 <= 容易写错。

## 复杂度

- 时间：O(log n)，两次二分
- 空间：O(1)

## 关键点

- 找最小值和 nums[right] 比：「大于」只对应 mid 在大段，「小于等于」只对应 mid 在小段
- 和 nums[left] 比，「大于」既可能是 mid 在大段，也可能是区间没旋转，分不清
- right=mid 不排除 mid，循环条件必须是 left<right，否则死循环
