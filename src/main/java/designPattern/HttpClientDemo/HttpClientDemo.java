package designPattern.HttpClientDemo;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Young
 * @Description:
 * @Date: Created at 10/9 0009 10:21
 */
public class HttpClientDemo {

    public static void main(String[] args) {
        demo2();
    }

    public static void demo2(){
        String xmlStr = "<111><222></111>";
        String str1 = xmlStr.split(">")[0];
        xmlStr = xmlStr.substring(str1.length());
        System.out.println("str1:" + xmlStr);

        String xmlStr2 = "<111><222></111>";
        String str2 = xmlStr2.split(">")[0] + ">";
        xmlStr2 = xmlStr2.substring(str2.length());
        System.out.println("str2:" + xmlStr2);
    }

    public static void demo1(){
        //CloseableHttpClient和HttpClient的区别
        //第一步:创建HttpClient实例对象
//        HttpClient client = new DefaultHttpClient();
        HttpClient client = HttpClients.createDefault();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //第二步:创建请求实例对象并赋予URL
        HttpGet get = new HttpGet("http://www.baidu.com");
//        HttpPost post = new HttpPost("http://www.baidu.com");
        //第三步:调用excute方法进行请求,返回HttpResponse
        try {
            CloseableHttpResponse res = httpClient.execute(get);
            System.out.println(res);
            System.out.println(res.getEntity());
            System.out.println(res.getStatusLine());
            res.getEntity().consumeContent();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * xml转成map集合
     * @param request
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    /*public Map<String, String> parseXml(HttpServletRequest request) throws Exception {
        //  创建存储实例
        Map<String, String> map = new HashMap<String, String>();
        //  从request中取得输入流
        InputStream inputStream = request.getInputStream();
        //  读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        String requestXml = document.asXML();
        String subXml = requestXml.split(">")[0] + ">";
        requestXml = requestXml.substring(subXml.length());
        //  获取根元素
        Element root = document.getRootElement();
        //  获取全部子节点
        List<Element> elementList = root.elements();
        //  遍历全部子节点
        for (Element e : elementList){
            map.put(e.getName(), e.getText());
        }
        map.put("requestXml", requestXml);
        //  关闭流
        inputStream.close();
        return map;
    }*/
}
