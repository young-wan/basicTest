package wechat.service;

import com.google.common.base.Strings;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wechat.module.AccessToken;
import wechat.module.WeChatEntity;
import wechat.utils.Constants;
import wechat.utils.JsSignUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: Young
 * @Description:
 * @Date: Created at 9/1 0001 10:51
 */
@Service
@Transactional
public class WeChatService {

    /**
     * 获取微信JSSDK的access_token
     * @author Benson
     */
   /* public static String getJSSDKAccessToken() {
        String returnString="";
        String requestUrl = weixin_jssdk_acceToken_url;
        JSONObject jsonObject = HttpRequest(requestUrl, "GET", null);  //Http GET请求
        // 如果请求成功
        if (null != jsonObject) {
            try {
                returnString=jsonObject.getString("access_token");
            } catch (JSONException e) {
                returnString = null;
            }
        }
        return returnString;
    }*/


    //获取微信JSSDK签名，用于调用微信扫一扫，返回对应数据
   /* public Map<String, String> getSignture(HttpServletRequest request, ModelAndView mav) {
        String js_accessToken = WeiXinUtil.getJSSDKAccessToken();  //获取微信jssdk---access_token
        String jsapi_ticket = WeiXinUtil.getTicket(js_accessToken); //获取微信jssdk---ticket
        System.out.println("jsapi_ticket==="+jsapi_ticket);

        //获取完整的URL地址
        String fullPath=BasePath.getFullPath(request);
        Map<String, String> data = JsSignUtil.sign(fullPath);
        mav.addObject("timestamp", data.get("timestamp"));
        mav.addObject("nonceStr", data.get("nonceStr"));
        mav.addObject("signature", data.get("signature"));
        return data;
    }*/

    /**
     * 获取用户关注信息
     *
     * @param accessToken
     * @param openId
     * @return
     * @throws Exception
     * @throws IOException
     */
    public WeChatEntity focusCheck(HttpServletResponse response, AccessToken accessToken, String openId) throws Exception, IOException {
        WeChatEntity weChatEntity = new WeChatEntity();
        JsonParser jsonparer = new JsonParser();// 初始化解析json格式
        String requestUrl = "";
        if (!Strings.isNullOrEmpty(openId)) {
            //根据openid数据库匹配是否关注
            if (openId.equals("null")) {
                //没有关注,跳转关注
                response.sendRedirect(Constants.GET_HOMEPAGE_URL);
            } else {
                //调用签到接口
                requestUrl = Constants.GET_USERINFO_URL.replace("ACCESSTOKEN", accessToken.getAccessToken()).replace("OPENID", openId);
                HttpClient client = new DefaultHttpClient();
                HttpGet get = new HttpGet(requestUrl);
                HttpResponse res = client.execute(get);
                String responseContent = null; // 响应内容
                HttpEntity entity = res.getEntity();
                responseContent = EntityUtils.toString(entity, "UTF-8");
                com.google.gson.JsonObject json = jsonparer.parse(responseContent).getAsJsonObject();
                // 如果请求成功
                //关注的话,json.get("subscribe")为1,未关注为0
                if (null != json) {
                    try {
                        weChatEntity.setOpenid(json.get("openid").getAsString());
                        weChatEntity.setNickname(json.get("nickname").getAsString());
                        weChatEntity.setSex(json.get("sex").getAsInt());
                        System.out.println("用户信息:" + weChatEntity);
                    } catch (Exception e) {
                        weChatEntity = null;
                        // 获取用户信息失败
                        System.out.println("获取用户信息失败 errcode:{} errmsg:{}");
                    }
                }
            }
        }
        return weChatEntity;
    }

    /**
     * token验证
     * @param request
     * @param response
     * @throws IOException
     */
    public void tokenCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter print;
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (signature != null && JsSignUtil.checkSignature(signature, timestamp, nonce)) {
            try {
                print = response.getWriter();
                print.print(echostr);
                print.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("signature校验不成功!");
            response.getWriter().write("signature校验不成功");
        }
    }

}
