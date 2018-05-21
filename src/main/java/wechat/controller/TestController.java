package wechat.controller;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wechat.service.TestService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @Author: Young
 * @Description:
 * @Date: Created at 9/20 0020 16:56
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {
    @Autowired
    private TestService testService;

    @ResponseBody
    @RequestMapping(value = "/test")
    public void test(HttpServletResponse response) throws IOException {
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter print = response.getWriter();
        /*print.println("test==测试");
        print.write("test==测试");
        print.write("\n测试");*/




        System.out.println("========Java测试======");
    }

}
