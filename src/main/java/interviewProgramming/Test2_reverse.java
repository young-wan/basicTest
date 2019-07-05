package interviewProgramming;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 7/1 0001 10:32
 */
public class Test2_reverse {

    /**
     * 请实现一个算法，在不使用额外数据结构和储存空间的情况下，翻转一个给定的字符串(可以使用单个过程变量)。
     * 给定一个string iniString，请返回一个string，为翻转后的字符串。保证字符串的长度小于等于5000。
     */
    public static void main(String[] args) {
        System.out.println(reverseString("This is nowcoder"));
    }

    public static String reverseString(String iniString) {
        int len = iniString.length();
        String[] arrays = new String[len];
        for (int i = 0; i < len / 2 + 1; i++) {
            arrays[i] = String.valueOf(iniString.charAt(len - 1 - i));
            arrays[len - 1 - i] = String.valueOf(iniString.charAt(i));
        }
        String res = "";
        for (int i = 0; i < arrays.length; i++){
            res += arrays[i];
        }
        return res;
    }
}
