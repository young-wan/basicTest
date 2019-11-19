package nowcoder;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/11/05 14:43
 */
public class StaticClass {

    public static class ClassOne implements intest {
        @Override
        public void print() {
            System.out.print("class 1111");
        }
    }

    public static class ClassTwo implements intest {
        @Override
        public void print() {
            System.out.print("Class 2222");
        }
    }

    public static class ClassThree implements intest {
        @Override
        public void print() {
            System.out.print("Class 3333");
        }
    }

    public static void test(Class<?> clz) {
        for (Class<?> type : clz.getClasses()) {
            System.out.print(type.getSimpleName() + ": ");
            try {
                intest<?> intest = (nowcoder.intest<?>) type.newInstance();
                intest.print();
                System.out.println();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        test(StaticClass.class);
    }

}

interface intest<T> {
    void print();
}
