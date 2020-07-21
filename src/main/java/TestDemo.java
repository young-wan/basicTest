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

//        System.out.println(recurse(8));
        System.out.println(rabbit(12));

    }
//1、1、2、3、5、8、13、21.....
    public static int recurse(int i){
        if (i == 1 || i == 2){
            return 1;
        }
        return recurse(i - 1) + recurse(i - 2);
    }

//    第二题：一般而言，兔子在出生两个月后，就有繁殖能力，一对兔子每个月能生出一对小兔子来。如果所有兔子都不死，那么一年以后可以繁殖多少对兔子？

//    1 1 2 3 5
    public static int rabbit(int month){
        if (month < 2){
            return 1;
        }
        return rabbit(month - 1) + rabbit(month - 2);

    }
}
