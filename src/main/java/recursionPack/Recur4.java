package recursionPack;

/**
 * @Author young
 * @Date 2020/7/17 14:24
 * @Desc 没完成
 **/
public class Recur4 {

//    【程序4】   题目：将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        f(90, sb);
        System.out.println(sb);
    }

    public static void f(int num, StringBuilder sb) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                num = num / i;
                sb.append(i).append("*");
                f(num, sb);
            }
        }
    }
}
