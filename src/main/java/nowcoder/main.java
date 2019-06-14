package nowcoder;

import org.apache.poi.hssf.usermodel.HSSFCell;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 1/26 0026 11:33
 */
public class main {
    public static void main(String[] args) {
//        int num = 10;
//        String str = "hello";
//        foo(num);
//        System.out.println("num: " + num);
//        foo(str);
//        System.out.println("str: " + str);
        String reg = "IF(1+({add}-40)*0.01>2.2,2.2,IF(1+(${add}-40)*0.01<1,1,1+(${add}-40)*0.01))";
        String add = "eee";
        System.out.println(reg.replaceAll("add", "eee"));
    }

    private static void foo(int value) {
        value = 100;
        System.out.println("foo-int : " + value);
    }

    private static void foo(String text) {
        text = "window";
        System.out.println("foo-string : " + text);
    }
}
