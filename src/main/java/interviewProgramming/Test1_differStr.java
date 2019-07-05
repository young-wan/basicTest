package interviewProgramming;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 7/1 0001 9:55
 */
public class Test1_differStr {
    /**
     * 请实现一个算法，确定一个字符串的所有字符是否全都不同。这里我们要求不允许使用额外的存储结构。
     * 给定一个string iniString，请返回一个bool值,True代表所有字符全都不同，False代表存在相同的字符。
     * 保证字符串中的字符为ASCII字符。字符串的长度小于等于3000。
     * <p>
     * 测试样例：
     * "aeiou"
     * 返回：True
     * "BarackObama"
     * 返回：False
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(checkDiffer("D-5H0F6T%Z?QM9,\72:[A8X! ;YJ#"));
    }

    public static boolean checkDiffer(String iniString) {
//        for (int i = 0; i < iniString.length(); i++) {
//            char charAt = iniString.charAt(i);
//            Integer charIndex = iniString.indexOf(charAt);
//            if (charIndex != i) {
//                return false;
//            }
//        }
//        return true;


        boolean[] charset = new boolean[65536];
        for(int i = 0;i < iniString.length(); i++){
            int val = iniString.charAt(i);
            if(charset[val]){
                return false;
            }
            charset[val] = true;
        }
        return true;
    }
}
