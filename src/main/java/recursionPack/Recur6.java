package recursionPack;

/**
 * @Author young
 * @Date 2020/7/17 15:08
 * @Desc
 **/
public class Recur6 {
//【程序6】   题目：输入两个正整数m和n，求其最大公约数和最小公倍数。

    public static void main(String[] args) {
        gcd(4, 6);
        gbs(5, 7);
    }

    // 辗转相除法
    public static void gcd(int x, int y) {
        int c;
        while (x % y != 0) {
            c = x % y;
            x = y;
            y = c;
        }
        System.out.println(y);
    }

    public static void gbs(int x, int y) {
        int n = x * y;
        int c;
        while (x % y != 0) {
            c = x % y;
            x = y;
            y = c;
        }
        System.out.println(n / y);
    }
}
