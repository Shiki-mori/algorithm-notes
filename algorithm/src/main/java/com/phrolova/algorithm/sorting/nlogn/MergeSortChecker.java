package com.phrolova.algorithm.sorting.nlogn;

import java.util.Arrays;
import java.util.Random;

/**
 * MergeSort 对数器：随机生成测试数据并调用 {@link MergeSort#mergeSort(int[])}。
 * <p>
 * 使用方法见 {@link #main(String[])} 及类内常量说明。
 */
public class MergeSortChecker {

    /** 随机测试轮数 */
    private static final int TEST_ROUNDS = 100_000;

    /** 数组长度上界（含），实际长度为 [1, MAX_ARRAY_SIZE] */
    private static final int MAX_ARRAY_SIZE = 100;

    /** 元素取值范围 [MIN_VALUE, MAX_VALUE] */
    private static final int MIN_VALUE = -100;
    private static final int MAX_VALUE = 100;

    /**
     * 是否开启正确性校验：与 {@link Arrays#sort(int[])} 结果比对。
     * 当前 MergeSort 尚在实现中，默认关闭。
     */
    private static final boolean CHECK_CORRECTNESS = true;

    /** 未开启校验时，打印前几轮输入/输出便于人工观察 */
    private static final int SAMPLE_PRINT_ROUNDS = 3;

    public static void main(String[] args) {
        Random random = new Random();
        int passed = 0;

        for (int round = 0; round < TEST_ROUNDS; round++) {
            int size = random.nextInt(MAX_ARRAY_SIZE) + 1;
            int[] original = generateRandomArray(size, MIN_VALUE, MAX_VALUE, random);
            int[] arr = copyArray(original);

            MergeSort.mergeSort(arr);

            if (CHECK_CORRECTNESS) {
                int[] expected = copyArray(original);
                Arrays.sort(expected);
                if (!equals(arr, expected)) {
                    System.out.println("第 " + round + " 轮失败：");
                    printArray("输入元素", original);
                    printArray("你的结果", arr);
                    printArray("正确结果", expected);
                    return;
                }
                passed++;
            } else if (round < SAMPLE_PRINT_ROUNDS) {
                System.out.println("--- 第 " + round + " 轮（仅展示，未校验）---");
                printArray("输入", original);
                printArray("输出", arr);
            }
        }

        if (CHECK_CORRECTNESS) {
            System.out.println("全部 " + passed + " 轮通过。");
        } else {
            System.out.println("已完成 " + TEST_ROUNDS + " 轮随机调用（未开启正确性校验）。");
            System.out.println("实现完成后，将 CHECK_CORRECTNESS 改为 true 再运行。");
        }
    }

    /** 生成长度为 size、元素在 [min, max] 内的随机数组 */
    public static int[] generateRandomArray(int size, int min, int max, Random random) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = min + random.nextInt(max - min + 1);
        }
        return arr;
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
