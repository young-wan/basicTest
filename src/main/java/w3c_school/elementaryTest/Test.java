package w3c_school.elementaryTest;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @title: notice-service
 * @copyright: Copyright © 2017-2020 汉博德信息技术有限公司 All Rights Reserved
 * @company: http://www.hanboard.com
 * @author: Young
 * @desc: 通知公告
 * @date: Created at 3/29 0029 11:45
 */
public class Test {
    public static void main(String[] args) {
        reverseTest("hello");

    }

    public static void reverseTest(String str){
        List<String> list = new ArrayList<String>();
        list = Arrays.asList(str.split(","));
        System.out.println(StringUtils.reverse(str));
    }
}
