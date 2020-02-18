package nowcoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 1/26 0026 11:32
 */
public class Test implements Comparable {
    private int sort;

    private int type;

    private final int i = 0;

    private final String a = "a";

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int compareTo(Object o) {
        final int i = 0;
        final Test a = new Test();
        a.setType(1);
        a.setSort(2);
        /**
         * static变量是属于类的,不和类的任何实例相关
         */
        return 0;
    }

    @Override
    public String toString() {
        return "Test{" +
                "sort=" + sort +
                ", type=" + type +
                '}';
    }

    public static void main(String[] args) {
        DateTimeFormatter dtfFull = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        DateTimeFormatter dtfYMD = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(dtfFull));
        System.out.println(now.format(dtfYMD));

        String timeStr = "20191227164253";
        LocalDate dateNow = LocalDate.parse(timeStr, dtfYMD);
        System.out.println(dateNow);
        LocalDateTime dateTime = LocalDateTime.parse(timeStr, dtfFull);
        System.out.println(dateTime);

    }

    public static Test t1(Test test) {
        test.sort = 11;
        test.type = 22;
        return test;
    }

    public static void t2(Test test) {
        test.sort = 111;
        test.type = 222;
    }


    public static int f(int x) {
        if (x <= 2) {
            return 1;
        }
        return f(x - 1) + f(x - 2);

    }


}
