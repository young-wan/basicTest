import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * @author Young
 * @create 2020-03-03 15:51
 * @desc leetcode
 * {@link}
 **/
public class TestDemo {

    public static void main(String[] args) {
//        Snowflake snowflake = new Snowflake();
//        for (int i = 0; i < 10; i++) {
//            System.out.println(snowflake.snowFlakeGenerate());
//        }
        int[] ints = new int[]{1, 2, 3};
//        int[] ints2 = ints;
//        ints2[1] = 11;
//        System.out.println(ints[1]);
//        System.out.println(sqrt(4));
        changeInt(ints);
        int i = 1;
        changeInt(i);
        System.out.println(ints[1]);
        System.out.println(i);
    }

    /**
     * 计算平方根（牛顿迭代法）
     *
     * @param c
     * @return
     */
    public static double sqrt(double c) {
        if (c < 0) {
            return Double.NaN;
        }
        double err = 1e-15;
        double t = c;
        while (Math.abs(t - c / t) > err * t) {
            t = (c / t + t) / 2.0;
        }
        return t;
    }

    public static void changeInt(int[] ints){
        ints[1] = 11;
    }

    public static void changeInt(int i){
        i = 11;
    }

}
