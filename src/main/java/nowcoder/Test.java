package nowcoder;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 1/26 0026 11:32
 */
public class Test {
    private int sort;

    private int type;

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Test{" +
                "sort=" + sort +
                ", type=" + type +
                '}';
    }

    public static void main(String[] args) {
        String plain = "TransId=IPER~~Mer_Id=900030~~Mer_IdName=2062289~~OrderNo=200710070021~~Amount=10.00~~" +
                "OrderDateTime=20191023142303~~CurrencyType=CNY~~ProductInfo=cdpaytest~~" +
                "MerURL=https://www.baidu.com~~MsgExt=regId";
        String[] plains = plain.split("~~");
        JSONArray jsonObject = JSONObject.parseArray(plain);
        System.out.println(jsonObject);
    }

    public static Test t1(Test test){
        test.sort = 11;
        test.type = 22;
        return test;
    }

    public static void t2(Test test){
        test.sort = 111;
        test.type = 222;
    }
}
