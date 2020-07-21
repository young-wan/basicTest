package recursionPack;

/**
 * @Author young
 * @Date 2020/7/16 16:58
 * @Desc 汉诺塔实验
 **/
public class Recur43 {
    static int count = 0;

    public static void main(String[] args) {
        test(6, 'x', 'y', 'z');
        System.out.println(" 总共移动了 " + count + " 次");
    }

    private static void test(int num, char x, char y, char z) {
        count++;
        if (num == 1) {
            // 只有1个的情况，直接从x移到z
            move(num, x, z);
        } else {
            // n-1个盘子先从x，通过z中转，放到y
            test(num - 1, x, z, y);
            // 移动第n个盘子到z目标点
            move(num, x, z);
            // 移动剩下的n-1个盘子（从y，经过x，到z）
            test(num - 1, y, x, z);
        }
    }

    public static void move(int num, char x, char y) {
        System.out.println("move " + num + " from " + x + " to " + y);
    }
}
