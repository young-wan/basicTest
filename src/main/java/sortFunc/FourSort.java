package sortFunc;

import java.util.*;

/**
 * @title: demo
 * @author: Young
 * @desc: 冒泡排序
 * @date: Created at 2019/12/25 16:48
 */
public class FourSort {

    public static void main(String[] args) {
        int total = 10;
        Integer[] integers = new Integer[total];
        Random random = new Random();
        for (int i = 0; i < total; i++) {
            integers[i] = random.nextInt(20);
        }
        System.out.println(Arrays.deepToString(integers));
        selectSort(integers);
//        bubbleSort(integers);
//        quickSort(integers, 0, integers.length -1);
        System.out.println(Arrays.deepToString(integers));
    }

    /**
     * 冒泡算法
     *
     * @param integers
     */
    public static void bubbleSort(Integer[] integers) {
        int t;
        for (int i = 0; i < integers.length - 1; i++) {
            for (int j = 0; j < integers.length - 1 - i; j++) {
                if (integers[j] > integers[j + 1]) {
                    t = integers[j];
                    integers[j] = integers[j + 1];
                    integers[j + 1] = t;
                }
            }
            System.out.println(Arrays.deepToString(integers));
        }
    }

    /**
     * 选择排序
     *
     * @param integers
     */
    public static void selectSort(Integer[] integers) {
        int t;
        for (int i = 0; i < integers.length; i++) {
            int min = i;
            for (int j = i + 1; j < integers.length; j++) {
                if (integers[min] > integers[j]) {
                    min = j;
                }
            }
            t = integers[i];
            integers[i] = integers[min];
            integers[min] = t;
            System.out.println(Arrays.deepToString(integers));
        }
    }

    public static void quickSort(Integer arr[], int min, int max) {
        int l = min;
        int h = max;
        int point = arr[min];

        //  l和h未碰面,继续递归
        while (l < h) {
            //  先从右边往前查询
            while (l < h && arr[h] >= point) {
                //  point右边的数都比point大时,往前查询
                h--;
            }
            if (l < h) {
                //  当找到比point小的数时,将该数和l交换;
                arr[l] = arr[h];
                l++;
            }
            //  从左边开始往后查询
            while (l < h && arr[l] <= point) {
                //  point左边的数都比point小时,往后查询
                l++;
            }
            if (l < h) {
                //  当找到比point大的数时,将该数和h交换;
                arr[h] = arr[l];
                h--;
            }
        }
        //  当l和h碰面,说明已经按point的值划分了左右两个小,大的数组;
        //  当前l/h下标即为point
        arr[l] = point;
        //  若还可以继续分解,则递归
        if (l - 1 > min) {
            //  当前的l下标还不是第一位,则递归左边数据
            quickSort(arr, min, l - 1);
        }
        if (h + 1 < max) {
            //  当前的h下标还不是最后一位,则递归右边数据
            quickSort(arr, h + 1, max);
        }
        for (Integer integer : arr) {
            System.out.print(integer + ",");
        }
        System.out.println("--------------------------\n");
    }
}
