package recursionPack;

/**
 * @Author young
 * @Date 2020/7/17 15:06
 * @Desc
 **/
public class Recur5 {

//    【程序5】   题目：利用条件运算符的嵌套来完成此题：学习成绩> =90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。

    public static void main(String[] args) {
        int score = 55;
        String str = score >= 90 ? "A" : (score > 60 ? "B" : "C");
        System.out.println(str);
    }
}
