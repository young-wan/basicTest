package wechat.utils;

import com.sun.jmx.snmp.Timestamp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Author: Young
 * @Description:
 * @Date: Created at 9/1 0001 14:52
 */
public class PropertiesUtil {
    private Properties props;
    private String fileName;

    public  Properties getProps() {
        return props;
    }
    public void setProps(Properties props) {
        this.props = props;
    }




    public PropertiesUtil(String fileName){
        this.fileName=fileName;
        readProperties(fileName);
    }
    /**
     * 鎻忚堪锛氳鍙杙roperties鏂囦欢
     * 浣滆€咃細herosky
     */
    public void readProperties(String fileName) {
        try {
            props = new Properties();
            FileInputStream fis =new FileInputStream(fileName);
            props.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 鑾峰彇鏌愪釜灞炴€?
     */
    public String getProperty(String key){
        return props.getProperty(key);
    }
    /**
     * 鑾峰彇鎵€鏈夊睘鎬э紝杩斿洖涓€涓猰ap,涓嶅父鐢?
     * 鍙互璇曡瘯props.putAll(t)
     */
    public Map getAllProperty(){
        Map map=new HashMap();
        Enumeration enu = props.propertyNames();
        while (enu.hasMoreElements()) {
            String key = (String) enu.nextElement();
            String value = props.getProperty(key);
            map.put(key, value);
        }
        return map;
    }

    /**
     * 鍦ㄦ帶鍒跺彴涓婃墦鍗板嚭鎵€鏈夊睘鎬э紝璋冭瘯鏃剁敤銆?
     */
    public void printProperties(){
        props.list(System.out);
    }
    /**
     * 鍐欏叆properties淇℃伅
     */
    public void writeProperties(String key, String value) {
        try {
            OutputStream fos = new FileOutputStream(fileName);
            props.setProperty(key, value);
            // 灏嗘 Properties 琛ㄤ腑鐨勫睘鎬у垪琛紙閿拰鍏冪礌瀵癸級鍐欏叆杈撳嚭娴?
            props.store(fos, "銆巆omments銆廢pdate key锛?" + key);
        } catch (IOException e) {
        }
    }
    public static void main(String[] args) {
        PropertiesUtil util=new PropertiesUtil(Constants.CONF_PROPERTIES_PATH);
        System.out.println("ACCESS_TOKEN=" + util.getProperty("ACCESS_TOKEN"));
        util.writeProperties("OVERDUE_ACCESS_TOKEN_TIME", "2015-03-25 16:36:37");
        Timestamp s = new Timestamp();
        System.out.println(s.getDateTime());

    }
}
