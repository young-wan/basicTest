package design_pattern.$14_strategy.sort;

import java.util.Arrays;

/**
 * @Author young
 * @Date 2021/1/29 14:21
 * @Desc
 **/
public class TestSort {
    public static void main(String[] args) {
        Cat[] cats = new Cat[]{new Cat(1, 3), new Cat(3, 5), new Cat(5, 1)};
        Dog[] dogs = new Dog[]{new Dog(3), new Dog(5), new Dog(1)};

        Sort<Cat> catSort = new Sort<>();
        catSort.sort(cats, (o1, o2) -> {
            if (o1.weight > o2.weight) return 1;
            else if (o1.weight < o2.weight) return -1;
            return 0;
        });

        Sort<Dog> dogSort = new Sort<>();
        dogSort.sort(dogs, ((o1, o2) -> {
            if (o1.age > o2.age) return 1;
            else if (o1.age < o2.age) return -1;
            return 0;
        }));

        System.out.println(Arrays.deepToString(cats));
        System.out.println(Arrays.deepToString(dogs));
    }
}
