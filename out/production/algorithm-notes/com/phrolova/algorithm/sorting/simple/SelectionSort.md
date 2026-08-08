# 选择排序

遍历数组，找到最小的元素，放到arr[0]；  
从arr[1]遍历，找到最小的元素，放到arr[1]；  
从arr[2]遍历，找到最小的元素，放到arr[2]；  
...

找到最小的元素：设定一个初始值，当遇到更小的元素时替换为该元素。  
放到arr[i]:交换arr[j]与arr[i]。  

## 初版

```java
package com.phrolova.algorithm.sorting.simple;

public class SelectionSort {
    public static int[] selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            swap(arr, minArr(arr), i);
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static int minArr(int[] arr) {
        int min = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[min] > arr[i]) {
                min = i;
            }
        }
        return min;
    }
}
```

缺陷：

minArr()每次都将寻找完整数组中的最小值。  
正确思路：每次仅寻找“未排序部分”的最小值。