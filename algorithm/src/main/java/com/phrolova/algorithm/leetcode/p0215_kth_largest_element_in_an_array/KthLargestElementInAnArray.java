package com.phrolova.algorithm.leetcode.p0215_kth_largest_element_in_an_array;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // 在 nums[l..r] 里，找升序排序后下标为 k 的那个数
    int quickSelect(int[] nums, int l, int r, int k) {
        if (l == r)
            // 此时 l==r==k
            return nums[k];

        // 选择nums[l]，即nums左端元素作为pivot
        int x = nums[l];
        // 左右指针
        int i = l - 1, j = r + 1;
        while (i < j) {
            do {
                i++;
            } while (nums[i] < x);
            do {
                j--;
            } while (nums[j] > x);
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        // 两种循环写法等价
        // int i = l, j = r;
        // while (i < j) {
        // while (nums[i] < x) {
        // i++;
        // }
        // while (nums[j] > x) {
        // j--;
        // }
        // if(...){
        // ...
        // }
        // }
        if (k <= j)
            return quickSelect(nums, l, j, k);
        else
            return quickSelect(nums, j + 1, r, k);
        // // 不能用i作为分界点，以下写法错误
        // if (k < i)
        //     return quickSelect(nums, l, i - 1, k);
        // else
        //     return quickSelect(nums, i, r, k);
    }

    public int findKthLargestQuickSelect(int[] _nums, int k) {
        int n = _nums.length;
        return quickSelect(_nums, 0, n - 1, n - k);
    }


    public int findKthLargestHeapSort(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        // 将堆顶换到末尾
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);

            // // 等价写法：
            // swap(nums, 0, i);
            // maxHeapify(nums, 0, i);
        }
        return nums[0];
    }

    // 建堆，时间复杂度：O(n)
    public void buildMaxHeap(int[] a, int heapSize) {
        // 下标>=heapSize/2的节点都是叶子，已经是堆
        // 因此对 heapSize/2 之前的所有节点执行下沉操作即可
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            maxHeapify(a, i, heapSize);
        }
    }

    // 下沉，维护堆的性质
    // i:待下沉的堆顶节点
    // heapSize: 仅对前heapSize个元素维护堆。后面的已排好。
    // 假设i的左右子树已经是堆，但a[i]可能比孩子小，就把它往较大一侧孩子下沉
    public void maxHeapify(int[] a, int i, int heapSize) {
        // 找i，l，r中最大值的下标largest
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // 大小为 k 的小顶堆，堆顶是堆内最小值，即当前 k 个最大里的最小 → 第 k 大
    public int findKthLargestPriorityQueue(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
    }
}
