package recursionPack;

/**
 * @Author young
 * @Date 2020/7/17 15:38
 * @Desc
 **/
public class Recur10 {

    //    【程序10】 题目：一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在   第10次落地时，共经过多少米？第10次反弹多高？
    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        ThreadLocal<String> threadLocal1 = new ThreadLocal<>();
        threadLocal.set(1);
        threadLocal1.set("2");
        threadLocal.remove();
        System.out.println(threadLocal.get());
        System.out.println(threadLocal1.get());
    }

    public static void f(int h) {

    }
}
