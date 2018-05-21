package wechat.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.jmx.snmp.Timestamp;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import wechat.module.AccessToken;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author: Young
 * @Description:
 * @Date: Created at 9/1 0001 12:41
 */
public class WeiXinUtil {
    public static AccessToken getAccessToken(String appid , String appsecret) throws Exception, IOException {

        AccessToken accessToken = null;
        JsonParser jsonparer = new JsonParser();// 初始化解析json格式的对�?
        String requestUrl = Constants.GET_ACCESSTOKEN_URL.replace("APPID" , appid).replace("APPSECRET" , appsecret);
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(requestUrl);
        HttpResponse res = client.execute(get);
        String responseContent = null; // 响应内容
        HttpEntity entity = res.getEntity();
        responseContent = EntityUtils.toString(entity, "UTF-8");
        JsonObject json = jsonparer.parse(responseContent).getAsJsonObject();
//        JSONObject jsonObject = JSONObject.fromObject(json);
        // 如果请求成功
        if (null != json) {
            try {
                accessToken = new AccessToken();
                accessToken.setAccessToken(json.get("access_token").getAsString());
                accessToken.setExpiresIn(json.get("expires_in").getAsInt());
            } catch (Exception e) {
                accessToken = null;
                // 获取token失败
                System.out.println("获取token失败 errcode:{} errmsg:{}");
            }
        }
        return accessToken;
    }

    public static String httpRequest(String requestUrl , String requestMethod , String outputStr) {
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始�?
            TrustManager[] tm = { new MyX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL" , "SunJSSE");
            sslContext.init(null , tm , new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST�?
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod)) httpUrlConn.connect();

            // 当有数据需要提交时
            if (null != outputStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱�?
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 将返回的输入流转换成字符�?
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream , "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
//          jsonObject = JSONObject.fromObject(buffer.toString());
            return buffer.toString();
        } catch (ConnectException ce) {
            System.out.println("Weixin server connection timed out.");
        } catch (Exception e) {
            System.out.println("error.");
        }
//      return jsonObject;
        return null;
    }



    public static void main(String[] args) {
        WeiXinUtil util = new WeiXinUtil();
        try {
            //获取accessToken之前判断文件里有没有，没有重新获取，填写过期时间，有判断时间有没有过�?
            PropertiesUtil putil=new PropertiesUtil(Constants.CONF_PROPERTIES_PATH);
            Long overduetime = Long.parseLong(putil.getProperty("OVERDUE_ACCESS_TOKEN_TIME"));
            Timestamp s = new Timestamp();
            AccessToken token = new AccessToken() ;
            if(s.getDateTime()>overduetime){
                //超时从新获取accessToken
                token = util.getAccessToken(Constants.APPID, Constants.SECRET);
                putil.writeProperties("OVERDUE_ACCESS_TOKEN_TIME", String.valueOf(s.getDateTime()+Constants.EFFECTIVE_TIME));
                putil.writeProperties("ACCESS_TOKEN", token.getAccessToken());
            }else{
                System.out.println("token:"+putil.getProperty("ACCESS_TOKEN")+",time:"+token.getExpiresIn());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取微信JSSDK的ticket
     */
    public static String getTicket(String access_token) {
        String ticket = null;
        if (Constants.jsapi_ticket_cache != null){
            ticket = Constants.jsapi_ticket_cache;
        }else {
            String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+ access_token +"&type=jsapi";//这个url链接和参数不能变
            try {
                URL urlGet = new URL(url);
                HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
                http.setRequestMethod("GET"); // 必须是get方式请求
                http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
                http.setDoOutput(true);
                http.setDoInput(true);
                System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
                System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
                http.connect();
                InputStream is = http.getInputStream();
                int size = is.available();
                byte[] jsonBytes = new byte[size];
                is.read(jsonBytes);
                String message = new String(jsonBytes, "UTF-8");
                JSONObject demoJson = JSONObject.fromObject(message);
                ticket = demoJson.getString("ticket");
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ticket;
    }
}
