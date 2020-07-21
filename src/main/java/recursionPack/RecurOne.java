package recursionPack;

/**
 * @Author young
 * @Date 2020/7/16 16:46
 * @Desc
 **/
public class RecurOne {

//    【程序1】   题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
//   小兔子长到第四个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？

    public static void main(String[] args) {
        System.out.println(test(12));
    }

    public static int test(int c) {
        if (c < 2) {
            return 1;
        }
        return test(c - 1) + test(c - 2);
    }
}
