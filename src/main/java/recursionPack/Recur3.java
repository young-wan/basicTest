package recursionPack;

/**
 * @Author young
 * @Date 2020/7/17 14:17
 * @Desc
 **/
public class Recur3 {
//    【程序3】   题目：打印出所有的 "水仙花数 "，所谓 "水仙花数 "是指一个三位数，其各位数字立方和等于该数本身。例如：153是一个 "水仙花数 "
//            ，因为153=1的三次方＋5的三次方＋3的三次方。

    public static void main(String[] args) {
        int res = 0;
        res = f(res);
        System.out.println("一共有水仙花" + res + "个");
    }

    public static int f(int res) {
        for (int i = 100; i < 1000; i++) {
            if (check(i)) {
                res++;
                System.out.println("找到一个水仙花数： " + i);
            }
        }
        return res;
    }

    public static boolean check(int num) {
        int x, y, z;
        x = num / 100;
        y = (num % 100) / 10;
        z = num % 10;
        if (num == (x * x * x) + (y * y * y) + (z * z * z)) {
            return true;
        }
        return false;
    }
}
