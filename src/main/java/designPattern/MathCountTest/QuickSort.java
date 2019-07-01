package designPattern.MathCountTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 6/12 0012 15:40
 */
public class QuickSort {

    public void sort(int arr[], int min, int max) {
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
                //  当找到比point小的数时,将该数和i交换;
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
            sort(arr, min, l - 1);
        }
        if (h + 1 < max) {
            //  当前的h下标还不是最后一位,则递归右边数据
            sort(arr, h + 1, max);
        }
        for (Integer integer : arr) {
            System.out.print(integer + ",");
        }
        System.out.println("--------------------------\n");
    }

    public void sortBucket(int arr[]) {
        List<Integer> maxList = new ArrayList<>();
        List<Integer> minList = new ArrayList<>();
        int index = 1;
        if (arr.length > 100) {
            for (int i = 0; i < arr.length; i++) {
                String str = numberToStr(arr[i]);
                if (str.charAt(str.length() - index) == 1) {
                    maxList.add(arr[i]);
                } else {
                    minList.add(arr[i]);
                }
            }
            index++;
        } else {
            sort(arr, 0, arr.length);
        }
        if (maxList.size() > minList.size()) {
            int[] list = maxList.stream().mapToInt(Integer::valueOf).toArray();
            sortBucket(list);
        } else {
            int[] list = minList.stream().mapToInt(Integer::valueOf).toArray();
            sortBucket(list);
        }
    }

    private String numberToStr(Integer number) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 32; i++) {
            sb.append(number & 1);
            number = number >>> 1;
        }
        return sb.toString();
    }

}
