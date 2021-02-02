import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

/**
 * @author Young
 * @create 2020-03-03 15:51
 * @desc leetcode
 * {@link}
 **/
public class TestDemo {
    private static String holidayUrl = "https://sp0.baidu.com/8aQDcjqpAAV3otqbppnN2DJv/api.php?query=YEAR&resource_id=6018&format=json";

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

    }

    public static int test(int cap) {
        int n = cap - 111;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 1;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 2;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 4;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 8;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 16;
        System.out.println(Integer.toBinaryString(n));
        return n + 1;
    }

    //1、1、2、3、5、8、13、21.....
    public static int recurse(int i) {
//        if (i == 1 || i == 2) {
//            return 1;
//        }
        if (i < 2) {
            return i;
        }
        return recurse(i - 1) + recurse(i - 2);
    }

//    第二题：一般而言，兔子在出生两个月后，就有繁殖能力，一对兔子每个月能生出一对小兔子来。如果所有兔子都不死，那么一年以后可以繁殖多少对兔子？

    //    1 1 2 3 5
    public static int rabbit(int month) {
        if (month < 2) {
            return 1;
        }
        return rabbit(month - 1) + rabbit(month - 2);

    }

    public static void test() {
        Integer[] integers = new Integer[]{1, 2, 3, 4};
        List<Integer> list = Arrays.asList(integers);
        list.add(5);
    }

    public void tt() {
//        StringBuilder;
//        StringBuffer;
//        String;
//        Integer;
//        Double;
    }
}
