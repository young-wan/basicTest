package nowcoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 1/26 0026 11:33
 */
public class main {
    public static void main(String[] args) {
//        int[] arr = new int[]{6, 3, 3, 4, 5, 6, 1, 8, 9};
////        System.out.println(binarySearch(arr, 10));
////        popSort(arr);
//        Map map = new HashMap();
//        map.put("userId", "1234");
//        System.out.println(map.get("userId"));
//        arrayTest(100000);
//        linkTest(100000);

        TreeSet<String> ts = new TreeSet(((o1, o2) -> {
            return 1;
        }));
        ts.add("a");
        ts.add("1");
        ts.add("2");
        System.out.println(ts.toString());

        Integer a = 1;
        for (String str : ts){
            System.out.println(str);
        }
        Iterator iterator = ts.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        HashSet hs = new HashSet();
        hs.add("a");
        hs.add("1");
        hs.add("2");
        System.out.println(hs.toString());

    }

    private static void arrayTest(int size) {
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            array.add(i);
        }
        Long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            array.add(size - 1, i);
        }
        Long end = System.currentTimeMillis();
        System.out.println("arrayTest  time---" + (start - end));
    }


    private static void linkTest(int size) {
        List<Integer> link = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            link.add(i);
        }
        Long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            link.add(size - 1, i);
        }
        Long end = System.currentTimeMillis();
        System.out.println("linkTest  time---" + (start - end));
    }

    private static int getInt() {
        int index = (int) (Math.random() * 10);
        if (index < 0 || index > 10001) {
            return getInt();
        }
        return index;
    }

    private static void foo(int value) {
        value = 100;
        System.out.println("foo-int : " + value);
    }

    private static void foo(String text) {
        text = "window";
        System.out.println("foo-string : " + text);
    }

    public static void popSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println(arr);

    }

    private void search(int[] arr, int min, int max) {
        int l = min;
        int h = max;
        int point = arr[l];

        while (l < h) {
            while (l < h && arr[h] >= point) {
                h--;
            }
            arr[l] = arr[h];
            l++;
            while (l < h && arr[l] <= point) {
                l++;
            }
            arr[h] = arr[l];
            h--;
        }
        arr[l] = point;
        if (l - 1 > min) {
            search(arr, min, l - 1);
        }
        if (h + 1 < max) {
            search(arr, h + 1, max);
        }
    }

    private static int binarySearch(int[] arr, int point) {
        int low = 0;
        int len = arr.length - 1;
        int mid = len / 2;
        while (low <= len) {
            if (arr[mid] == point) {
                return mid;
            } else if (arr[mid] < point) {
                low = mid + 1;
                mid = (low + len) / 2;
            } else if (arr[mid] > point) {
                len = mid - 1;
                mid = (low + len) / 2;
            }
        }
        return -1;
    }

}
