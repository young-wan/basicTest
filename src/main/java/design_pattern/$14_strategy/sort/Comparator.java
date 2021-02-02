package design_pattern.$14_strategy.sort;

/**
 * @Author young
 * @Date 2021/1/29 14:19
 * @Desc
 **/
public interface Comparator<T> {
    int compareTo(T o1, T o2);
}
