# 题解：Longest Subarray of 1's After Deleting One Element

## 思路

对于[l.r]：

若仅有1个0，则能得到r-l的子数组。

若没有0，则能得到r-l的子数组。

#### 计算[l,r]0的个数

定义前缀和

preSum[i]=preSum[i-1]+nums[i]

1个0：前缀和preSum[r]-preSum[l-1]=r-l

0个0：前缀和preSum[r]-preSum[l-1]=r-l+1

前缀和单调递增

preSum[r+1]-r+l

## 复杂度

- 时间：
- 空间：

## 关键点

