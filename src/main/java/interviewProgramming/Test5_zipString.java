package interviewProgramming;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 7/1 0001 11:35
 */
public class Test5_zipString {

    /**
     * 利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。
     * 比如，字符串“aabcccccaaa”经压缩会变成“a2b1c5a3”。若压缩后的字符串没有变短，则返回原先的字符串。
     * <p>
     * 给定一个string iniString为待压缩的串(长度小于等于10000)，保证串内字符均由大小写英文字母组成，
     * 返回一个string，为所求的压缩后或未变化的串。
     *
     * @param args
     */

    public static void main(String[] args) {
        System.out.println(zipString("aabcccccaaa"));
        System.out.println(zipString("welcometonowcoderrrrr"));
    }

    public static String zipString(String iniString) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iniString.length(); i++) {
            char temp = iniString.charAt(i);
            int count = 1;
            while (i < iniString.length()-1 && iniString.charAt(i+1) == iniString.charAt(i)) {
                count ++;
                i ++;
            }
            stringBuffer.append(temp).append(count);
        }
        return iniString.length() > stringBuffer.length() ? stringBuffer.toString() :iniString;
    }
}
