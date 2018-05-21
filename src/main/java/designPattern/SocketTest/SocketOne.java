package designPattern.SocketTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Map;

/**
 * @title: moral-edu-service
 * @copyright: Copyright © 2017-2020 汉博德信息技术有限公司 All Rights Reserved
 * @company: http://www.hanboard.com
 * @author: Young
 * @desc: 德育系统
 * @date: Created at 5/21 0021 15:48
 */
public class SocketOne {
    public static void main(String[] args) {
//         address();
//        portTest();
//        remoteFileTest();
//        remoteConn();
//        urlHtml();
//        urlHeaders();
        urlInfo();
    }

    private static void urlInfo(){
        try {
            URL url = new URL("http://www.runoob.com/html/html-tutorial.html");
            System.out.println("URL 是 " + url.toString());
            System.out.println("协议是 " + url.getProtocol());
            System.out.println("文件名是 " + url.getFile());
            System.out.println("主机是 " + url.getHost());
            System.out.println("路径是 " + url.getPath());
            System.out.println("端口号是 " + url.getPort());
            System.out.println("默认端口号是 "
                    + url.getDefaultPort());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private static void urlHeaders(){
        try {
            URL url = new URL("http://www.runoob.com");
            HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
            long date = httpConnection.getDate();
            Map headers = httpConnection.getHeaderFields();
            for (Object key : headers.keySet()){
                String val = httpConnection.getHeaderField((String) key);
                System.out.println(key + "=" + val);
            }
            System.out.println(new Date(date));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void urlHtml(){
        try {
            URL url = new URL("http://www.runoob.com");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            BufferedWriter bw = new BufferedWriter(new FileWriter("data.html"));
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
                bw.write(line);
                bw.newLine();
            }
            br.close();
            bw.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void remoteConn(){
        InetAddress inetAddress = null;
        try {
            Socket socket = new Socket("www.runoob.com", 80);
            inetAddress = socket.getInetAddress();
            System.out.println("连接到www.runoob.com" + inetAddress);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void remoteFileTest(){
        int size;
        URLConnection connection;
        try {
            URL url = new URL("http://www.runoob.com/wp-content/themes/runoob/assets/img/newlogo.png");
            connection = url.openConnection();
            size = connection.getContentLength();
            System.out.println(size);
            connection.getInputStream().close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void portTest(){
        Socket socket;
        String host = "localhost";
        for (int i = 10; i < 1024; i++){
            try {
                System.out.println("检查端口" + i);
                socket = new Socket(host, i);
                System.out.println("端口" + i + "已被占用");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void address(){
        InetAddress inetAddress = null;
        try {
//            inetAddress = InetAddress.getByName("www.baidu.com");
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println("getAddress:" + inetAddress.getAddress());
        System.out.println("getHostAddress:" + inetAddress.getHostAddress());
        System.out.println("getHostName:" + inetAddress.getHostName());
        System.out.println("getCanonicalHostName:" + inetAddress.getCanonicalHostName());

        try {
            System.out.println(InetAddress.getLocalHost());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
