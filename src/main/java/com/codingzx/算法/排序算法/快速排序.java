package com.codingzx.算法.排序算法;

/**
 * @author codingzx
 * @description
 * @date 2020/5/21 19:26
 */
public class 快速排序 {

    public static void quickSort(int[] array, int leftIndex, int rightIndex) {
    }

    public static void quickSort2(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            return;
        }
        // 左边第一个元素
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
            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            // 交换 left和right
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

    public static void main(String[] args) {
        int[] arr = {25, 67, 89, 234, 210, 256, 10};
        quickSort2(arr, 0, arr.length-1);
        for(int i: arr){
            System.out.println(i);
        }
    }


}
