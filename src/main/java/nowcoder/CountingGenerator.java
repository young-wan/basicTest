package nowcoder;

import java.util.Random;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/11/05 14:57
 */
public class CountingGenerator {
    private static Random random = new Random(47);

    public static class IntegerTest implements Generator<Integer> {
        private int mod = 10000;

        public IntegerTest() {
        }

        public IntegerTest(int mod) {
            this.mod = mod;
        }

        @Override
        public java.lang.Integer next() {
            return random.nextInt(mod);
        }
    }

    public static class StringTest implements Generator<String> {

        @Override
        public String next() {
            return defaultStr;
        }

        private static String defaultStr = "defaultStr";

    }

    public static void main(String[] args) {
        for (Class<?> clz : CountingGenerator.class.getClasses()) {
            System.out.println(clz.getSimpleName());
            try {
                Generator<?> generator = (Generator<?>) clz.newInstance();
                for (int i = 0; i < 3; i++) {
                    System.out.println(generator.next());
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}

