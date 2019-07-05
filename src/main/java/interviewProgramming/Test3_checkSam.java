package interviewProgramming;

import java.util.Arrays;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 7/1 0001 10:49
 */
public class Test3_checkSam {

    /**
     * 给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。这里规定大小写为不同字符，且考虑字符串中的空格。
     * <p>
     * 测试样例：
     * "This is nowcoder","is This nowcoder"
     * 返回：true
     * "Here you are","Are you here"
     * 返回：false
     *
     * @param args
     */

    public static void main(String[] args) {
        System.out.println(checkSam("This is nowcoder", "is This nowcoder"));
        System.out.println(checkSam("Here you are", "Are you here"));
    }

    public static boolean checkSam(String stringA, String stringB) {
//        if (null == stringA || null == stringB){
//            return false;
//        }
//        if (stringA.length() != stringB.length()) {
//            return false;
//        }
//        int[] ascA = new int[stringA.length()];
//        int[] ascB = new int[stringA.length()];
//
//        for (int i = 0; i < stringA.length(); i++) {
//            ascA[i] = stringA.charAt(i);
//            ascB[i] = stringB.charAt(i);
//        }
//        Arrays.sort(ascA);
//        Arrays.sort(ascB);
//        for (int i = 0; i < ascA.length; i++){
//            if (ascA[i] != ascB[i]){
//                return false;
//            }
//        }
//        return true;

        char[] aa = stringA.toCharArray();
        char[] bb = stringB.toCharArray();
        Arrays.sort(aa);
        Arrays.sort(bb);
        return Arrays.equals(aa,bb);

    }
}
