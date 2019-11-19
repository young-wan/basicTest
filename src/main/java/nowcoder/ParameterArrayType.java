package nowcoder;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/11/05 11:42
 */
class ClassParameter<T> {
    public T[] f(T[] args) {
        return args;
    }
}

class MethodParameter {
    public static <T> T[] f(T[] args) {
        return args;
    }
}

public class ParameterArrayType {
    public static void main(String[] args) {
//        Integer[] ints = {1, 2, 3, 4, 5};
//        Double[] doubles = {1.1, 2.2, 3.3, 4.4, 5.5};
//        Integer[] ints2 = new ClassParameter<Integer>().f(ints);
//        Double[] doubles2 = new ClassParameter<Double>().f(doubles);
//        ints2 = MethodParameter.f(ints);
//        doubles2 = MethodParameter.f(doubles);
//
//        List<String>[] list;
//        List[] lists = new List[2];
//        list = lists;
//        list[0] = new ArrayList<String>();
//        list[1] = new ArrayList<>();


//        ClassParameter<Shape> ls = new ClassParameter<>();
//        ClassParameter<Circle> li = new ClassParameter<>();
//        System.out.println(ls.getClass());
//        System.out.println(li.getClass());
//        System.out.println(ls.getClass().equals(li.getClass()));
//        Object[] objects = {1, "3", new ArrayList<>(), new HashMap<>(9)};
//        for (Object object : objects) {
//            System.out.println(object);
//        }
//        Integer[] integers = new Integer[10];
//        Arrays.fill(integers, 2);
//        System.out.println(Arrays.toString(integers));

    }

}
