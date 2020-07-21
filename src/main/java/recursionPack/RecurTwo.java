package recursionPack;

/**
 * @Author young
 * @Date 2020/7/16 16:46
 * @Desc
 **/
public class RecurTwo {

//    题目：判断101-200之间有多少个素数，并输出所有素数。

    public static void main(String[] args) {
        int res = 0;
        System.out.println(test(res));
    }

    public static int test(int res) {
        for (int i = 101; i <= 200; i++){
            if (check(i)){
                res++;
                System.out.println(i + "是素数");
            }
        }
        return res;
    }

    public static boolean check(int num){
        for (int i = 2; i < num / 2; i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}
