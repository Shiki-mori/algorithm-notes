package com.phrolova.algorithm.sorting.nlogn;

import java.util.Arrays;

/**
 * MergeSort 固定序列对数器：使用长度为 30 的预设数组调用 {@link MergeSort#mergeSort(int[])}，便于单步调试。
 * <p>
 * 使用方法见 {@link #main(String[])} 及类内常量说明。
 */
public class MergeSortDebugChecker {

    /** 固定调试用数组，长度恒为 30 */
    private static final int[] DEBUG_ARRAY = {
            38, 27, 43, 3, 9, 82, 10, 15, 7, 44,
            28, 39, 51, 1, 14, 6, 19, 22, 33, 5,
            48, 31, 12, 8, 41, 25, 17, 36, 23, 11
    };

    /**
     * 是否开启正确性校验：与 {@link Arrays#sort(int[])} 结果比对。
     * 当前 MergeSort 尚在实现中，默认关闭。
     */
    private static final boolean CHECK_CORRECTNESS = true;

    public static void main(String[] args) {
        int[] original = copyArray(DEBUG_ARRAY);
        int[] arr = copyArray(original);

        printArray("输入", original);
        MergeSort.mergeSort(arr);
        printArray("输出", arr);

        if (CHECK_CORRECTNESS) {
            int[] expected = copyArray(original);
            Arrays.sort(expected);
            if (equals(arr, expected)) {
                System.out.println("固定序列校验通过。");
            } else {
                System.out.println("固定序列校验失败：");
                printArray("正确结果", expected);
            }
        } else {
            System.out.println("未开启正确性校验（仅展示输入/输出）。");
            System.out.println("实现完成后，将 CHECK_CORRECTNESS 改为 true 再运行。");
        }
    }

    public static int[] copyArray(int[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }

    public static boolean equals(int[] a, int[] b) {
        return Arrays.equals(a, b);
    }

    public static void printArray(String label, int[] arr) {
        System.out.println(label + ": " + Arrays.toString(arr));
    }
}
