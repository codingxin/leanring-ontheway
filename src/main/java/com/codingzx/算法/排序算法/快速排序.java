package com.codingzx.算法.排序算法;

/**
 * @author codingzx
 * @description
 * @date 2020/5/21 19:26
 */
public class 快速排序 {

    public static void quickSort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }

        int left = leftIndex;
        int right = rightIndex;
        // 待排序的第一个元素作为基准值
        int key = array[left];
        while (left < right) {
            // 从最右边找到第一个大于key的下标
            while (right > left && array[right] >= key) {
                right--;
            }
            //找到这种元素将arr[left]放入arr[right]中
            array[right] = array[left];
        }
        // 将基准值放入最左边
        array[left] = key;
        quickSort(array, leftIndex, left - 1);
        quickSort(array, right + 1, rightIndex);
    }

    public static void quickSort2(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            return;
        }
        int base = array[leftIndex];
        int left = leftIndex;
        int right = rightIndex;
        while (left != right) {
            while (array[right] >= base && left < right) {
                right--;
            }
            while (array[left] <= base && left < right) {
                left++;
            }
            if (left < right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
            }
        }
        // 将第一个值（基准值）和中间分界值交换
        array[leftIndex] = array[left];
        array[left] = base;



        quickSort2(array, leftIndex, left - 1);
        quickSort2(array, right + 1, rightIndex);


    }

}
