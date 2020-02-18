package sortFunc;

import java.util.Random;

/**
 * @title: demo
 * @author: Young
 * @desc: 冒泡排序
 * @date: Created at 2019/12/25 16:48
 */
public class FourSort {

    public static void main(String[] args) {
        Integer[] integers = new Integer[20];
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            integers[i] = random.nextInt(20);
        }
        System.out.println(integers);
        bubbleSort(integers);
        System.out.println(integers);

    }

    public static void bubbleSort(Integer[] integers) {
        int t = 0;
        for (int i = 0; i < integers.length - 1; i++) {
            for (int j = 0; j < integers.length - 1 - i; j++) {
                if (integers[j] > integers[j + 1]) {
                    t = integers[j];
                    integers[j] = integers[j + 1];
                    integers[j + 1] = t;
                }
            }
        }
    }

    public void selectSort(Integer[] integers) {
        int t = 0;
        for (int i = 0; i < integers.length; i++) {
            int index = i;
            for (int j = 0; j < integers.length; j++) {
                if (integers[i] > integers[j]) {
                    index = j;
                }
            }
        }
    }

}
