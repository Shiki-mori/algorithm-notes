package com.phrolova.algorithm.hot100.p0239_sliding_window_maximum;

public class SlidingWindowMaximum {

    // 失败作
    // 重排序，记录下标
    // 窗口的所有下标，根据原下标得到排序后的下标，返回最大下标对应的值
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;

        // 下标数组
        int[] sortedNums = new int[length];
        for (int i = 0; i < length; i++) {
            sortedNums[i] = i; // 下标
        }
        Arrays.sort(sortedNums, (a, b) -> Integer.compare(nums[a], nums[b]));

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++)
            map.put(sortedNums[i], i);

        // 初始窗口
        for(int i=0;i<k;i++){
            map.
        }

        for (int i = 0; i < length - k + 1; i++) {
            for(int i=0;i<k;i++){

            }
        }

    }

    // ----------------------------------------
    // 优先队列/堆

    public int[] maxSlidingWindowHeap(int[] nums, int k) {
        int length = nums.length;

        // 建大根堆
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        // 初始化堆
        for (int i = 0; i < k; i++) {
            pq.offer(new int[] { nums[i], i });
        }

        int[] ans = new int[length - k + 1];
        ans[0] = pq.peek()[0];

        for (int i = k; i < length; i++) {
            pq.offer(new int[] { nums[i], i });
            while (pq.peek()[1] < i - k + 1) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }

        return ans;
    }

    // ------------------------------------------
    // 单调队列

    public int[] maxSlidingWindowDeque(int[] nums, int k) {
        int length = nums.length;

        int[] ans = new int[length - k + 1];

        Deque<Integer> deque = new LinkedList<>();
        // 初始化队列
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        ans[0] = nums[deque.peekFirst()];

        for (int i = 1; i < length - k + 1; i++) {
            while (!deque.isEmpty() && nums[i + k - 1] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i + k - 1);
            while (deque.peekFirst() < i) {
                deque.pollFirst();
            }
            ans[i] = nums[deque.peekFirst()];
        }

        return ans;
    }

    public static void main(String[] args) {
    }
}
