package wechat.utils;

/**
 * @Author: Young
 * @Description: 常量
 * @Date: Created at 9/1 0001 14:48
 */
public class Constants {
    /**
     * APPID
     */
    public static String APPID = "wxfb6f5be2f2c10ef5";
    /**
     * SECRET
     */
    public static String SECRET = "16d8cd5d3f4ad13fb1f4bfd8d128c2b1";

    public static String jsapi_ticket_cache = null;
    /**
     * 获取ACCESS_TOKEN接口
     */
    public static String GET_ACCESSTOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    /**
     * ACCESS_TOKEN有效时间(单位：ms)
     */
    public static int EFFECTIVE_TIME = 700000;
    /**
     * conf.properties文件路径
     */
    public static String CONF_PROPERTIES_PATH = "src/conf/config.properties";

    /**
     * 微信获取用户信息
     */
    public static String GET_USERINFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESSTOKEN&openid=OPENID";

    /**
     * 微信获取ticket
     */
    public static String GET_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESSTOKEN&type=jsapi";

    /**
     * 获取关注者列表
     */
    public static String GET_FOCUSLIST_URL = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESSTOKEN&next_openid=";

    /**
     * 生成二维码ticket
     */
    public static String GET_QRCODE_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESSTOKEN";

    /**
     * 打印公众号二维码
     */
    public static String GET_SHOWCODE_URL = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";

    /**
     * 公众号主页二维码地址
     */
    public static String GET_HOMEPAGE_URL = "http://weixin.qq.com/r/qS3F3YDEPd1CrcS_93i7";

}
