package design_pattern.$14_strategy.sort;

/**
 * @Author young
 * @Date 2021/1/29 14:23
 * @Desc
 **/
public class Sort<T> {
    public void sort(T[] list, Comparator<T> comparator) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (comparator.compareTo(list[j], list[j + 1]) > 0) {
                    swap(list, j, j + 1);
                }
            }
        }
    }

    public void swap(T[] list, int min, int max) {
        T t = list[min];
        list[min] = list[max];
        list[max] = t;
    }
}
