package recursionPack;

import java.io.File;

/**
 * @Author young
 * @Date 2020/7/16 19:42
 * @Desc
 **/
public class Recur44 {

    public static void main(String[] args) {
//        System.out.println(f1(10));
//        f2(file);
        StringBuilder sb = new StringBuilder();
        System.out.println(f3(10, sb));
        System.out.println(sb.substring(0, sb.length() - 1));
    }

    /**
     * 有个楼梯，台阶有10个，每次可以跳上1阶 或者 2阶 ，那么台阶的走法一共有多少种
     *
     * @param num
     * @return
     */
    public static int f1(int num) {
        if (num == 1) {
            return 1;
        }
        if (num == 2) {
            return 2;
        }
        return f1(num - 1) + f1(num - 2);
    }


    static File file = new File("D:/test");

    /**
     * 文件删除递归
     * <p>
     * 1:检测文件夹是否存在，不存在则退出
     * 2:获取该文件夹目录【获取文件数组】，遍历文件数组
     * 3:判断是文件则删除，不是则回调 2
     * 4.文件删除完后，将该文件夹删除
     */
    public static void f2(File file) {
        if (!file.exists()) {
            System.out.println("文件不存在");
            return;
        }

        File[] listFiles = file.listFiles();
        for (File f : listFiles) {
            if (f.isFile()) {
                System.out.println("文件： " + f.getName());
            } else {
                System.out.println("文件夹： " + f.getName());
                f2(f);
            }
        }

    }


    /**
     * 使用递归方式计算 随机数 [1,10]的乘阶结果并打印过程
     *
     * @param num
     * @return
     */
    public static int f3(int num, StringBuilder sb) {
        sb.append(num).append("*");
        if (num == 1) {
            return 1;
        }
        return f3(num - 1, sb) * num;
    }

}
