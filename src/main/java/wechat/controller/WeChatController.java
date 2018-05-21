package wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import wechat.module.AccessToken;
import wechat.service.WeChatService;
import wechat.utils.Constants;
import wechat.utils.WeiXinUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Young
 * @Description: 微信签到
 * @Date: Created at 9/1 0001 10:50
 */
@Controller
@RequestMapping(value = "/training/wechat/sign")
public class WeChatController {

    @Autowired
    private WeChatService weChatService;

    @ResponseBody
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        System.out.println("测试接口功能");
        return "测试接口功能";
    }

    /**
     * 接口配置token验证
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/tokenCheck", method = RequestMethod.GET)
    public void getToken(HttpServletRequest request, HttpServletResponse response)throws IOException{
        System.out.println("执行 tokenCheck");
        weChatService.tokenCheck(request, response);
        System.out.println("返回结果(tokenCheck)");
    }

    @ResponseBody
    @RequestMapping(value = "/focusCheck", method = RequestMethod.GET)
    public void focusCheck(HttpServletResponse response, String openId) throws Exception, IOException {
        System.out.println("执行 focusCheck");
        AccessToken accessToken = WeiXinUtil.getAccessToken( Constants.APPID, Constants.SECRET);
        weChatService.focusCheck(response, accessToken, openId);
        System.out.println("返回结果(focusCheck)");
    }
}
