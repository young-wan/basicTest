package nowcoder;

import java.io.File;
import java.util.Arrays;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/11/11 10:58
 */
public class DirList {
    public static void main(String[] args) {
        File file = new File("/");
        String[] list = file.list();

        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
