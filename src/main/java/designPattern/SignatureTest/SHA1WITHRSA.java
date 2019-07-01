package designPattern.SignatureTest;


import com.sun.org.apache.xml.internal.security.utils.Base64;
import utils.JsSignUtil;

import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 6/24 0024 15:28
 */
public class SHA1WITHRSA {
    public static void main(String[] args) throws Exception {
        String strToSign = "branchNo=0101&dateTime=20160701123456&httpMethod=POST&merchantNo=123456&" +
                "noticeSerialNo=201607019876543210&noticeType=ABCDEFGH&" +
                "noticeUrl=http://99.12.38.88:8086/RecvNotice/NoticeRcv.ashx&param1=111&param2=a中转周末b";
        String strSign = "Pez08MLS6tnrPTnO2febDbHmZ1FNB8Rgy1dp82XwPXkWbP0XPFZAy0ElRomJnMGuGNEwz9hC6" +
                "1TUNhRYhb22ZEHhFMpMNZWFeiN1ewXwIT5Sx7VmE4InfklQnVub0dRr1d6zJ3gprMHBoiQBe8xAxpd1y+82Jm5z7IkvLtgWXU4=";
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDZs4l8Ez3F4MG0kF7RRSL+pn8MmxVE3nfdXzjx6d3rH8I" +
                "fDbNvNRLS0X0b5iJnPyFO8sbbUo1Im4zX0M8XA0xnnviGyn5E6occiyUXJRgokphWb5BwaYdVhnLldctdimHoJTk3N" +
                "FEQFav3guygR54i3tymrDc8lWtuG8EczVu8FwIDAQAB";
        System.out.println(isValidSignature(strToSign, strSign, publicKey));
    }


    /**
     * 获取一网通签名
     *
     * @param map
     * @return
     */
    public static String getSignStr(Map map) {
        StringBuilder sb = new StringBuilder();
//        //  将map参数转为treemap字典排序
//        Map<String, String> paraMap = new TreeMap<>(map);
//        Set<String> set = paraMap.keySet();
//        for (String key : set) {
//            sb.append(key + "=" + paraMap.get(key) + "&");
//        }
        sb.append("branchNo=0101&dateTime=20160701123456&httpMethod=POST&merchantNo=123456&noticeSerialNo=201607019876543210&noticeType=ABCDEFGH&noticeUrl=http://99.12.38.88:8086/RecvNotice/NoticeRcv.ashx&param1=111&param2=a中转周末b");
        MessageDigest md = null;
        String tmpStr = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
            // 将三个参数字符串拼接成一个字符串进行sha256加密
            byte[] digest = md.digest(sb.toString().getBytes("UTF-8"));
            tmpStr = JsSignUtil.byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        tmpStr = tmpStr.substring(0, tmpStr.length() - 1);
        System.out.println("sign---" + tmpStr);
        System.out.println("sign---" + tmpStr.length());
        return tmpStr;
    }

    /**
     * 验签
     *
     * @param strToSign 待验签字符串(字典排序)
     * @param strSign   (银行报文sign)
     * @param publicKey (银行公钥)
     * @return
     */
    public static boolean isValidSignature(String strToSign, String strSign, String publicKey) {
//        Init.init();
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = Base64.decode(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
            Signature signature = Signature.getInstance("SHA1WithRSA");
            signature.initVerify(pubKey);
            signature.update(strToSign.getBytes("UTF-8"));
            byte[] signByte = Base64.decode(strSign);
            boolean flag = signature.verify(signByte);
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
