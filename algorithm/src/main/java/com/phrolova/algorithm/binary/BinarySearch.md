# 二分法

## 在一个有序数组中，查找某个数是否存在

中点，左边界，右边界  
mid，left，right

更新规则：

```java
public int binarySearch() {
    while (left <= right) {
        mid = (left + right) / 2;
        if (target > arr[mid]) {
            left = mid + 1;
        } else if (target < arr[mid]) {
            right = mid - 1;
        } else {
            return mid;
        }
    }
    return -1;
}
```

令`mid=left+(right-left)/2` ，能有效防止(left+right)溢出。

### 复杂度

时间复杂度：O(logN)

## 在一个有序数组中，找>=某个数最左侧的位置

1223334455

中点，左边界，右边界  
mid，left，right

目标：target

当前最左侧标记leftTick

```text
when(left<=right){
    if arr[mid]<target
        left=mid+1
    else if arr[mid]>=target
        right=mid-1
        if leftTick>mid
            leftTick=mid
        endif
    endif
}
```

## 局部最小值问题

一个无序数组，其中任意两个相邻数都不相等。  
对于arr[0],若arr[0]<arr[1]，则arr[0]局部最小；  
对于arr[n-1],若arr[n-1]<arr[n-2]，则arr[n-1]局部最小；  
对于arr[i]，若arr[i]<arr[i-1]&&arr[i]<arr[i+1]，则arr[i]局部最小。  
求一个局部最小。

先检查arr[0]和arr[n-1]，若是局部最小，直接返回。  
若不是局部最小，则arr[0]>arr[1],arr[n-2]<arr[n-1]。  
0~n-1之间必存在局部最小。  

取中点m。  
若arr[m-1]>arr[m]&&arr[m]<arr[m+1]，则返回m。  
否则：  
- 当arr[m-1]<arr[m]时，  
    0~m之间必存在局部最小；  
- 当arr[m]>arr[m+1]时，  
    m~n-1之间必存在局部最小。