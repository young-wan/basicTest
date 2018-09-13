package designPattern.SocketTest;

import com.google.common.base.Strings;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @title: moral-edu-service
 * @copyright: Copyright © 2017-2020 汉博德信息技术有限公司 All Rights Reserved
 * @company: http://www.hanboard.com
 * @author: Young
 * @desc: 德育系统
 * @date: Created at 5/21 0021 17:47
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("启动服务器...");
            Scanner scanner = new Scanner(System.in);
            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("客户端" + socket.getInetAddress().getHostAddress() + "已连接到服务器...");
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
//
//                byte[] bytes = new byte[1024];
//                int len;
//                while ((len = is.read(bytes)) != -1){
//                    System.out.println("print: " + new String(bytes, 0, len));
//                }
//                os.write(("hello, i get msg : " + new String(bytes, 0, len)).getBytes());

                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line = br.readLine();
                System.out.println("客户端: " + line);
                String res = scanner.next();
                BufferedWriter bw;
                if (!Strings.isNullOrEmpty(res)){
                    bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    bw.write(res + "\n");
                    bw.flush();
                    bw.close();
                }
                br.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
