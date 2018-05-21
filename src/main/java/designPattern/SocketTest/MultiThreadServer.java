package designPattern.SocketTest;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @title: moral-edu-service
 * @copyright: Copyright © 2017-2020 汉博德信息技术有限公司 All Rights Reserved
 * @company: http://www.hanboard.com
 * @author: Young
 * @desc: 德育系统
 * @date: Created at 5/21 0021 16:53
 */
public class MultiThreadServer  implements Runnable {
    Socket csocket;
    MultiThreadServer (Socket csocket){
        this.csocket = csocket;
    }

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("start listening...");
            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("connected");
                new Thread(new MultiThreadServer (socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            PrintStream pstream = new PrintStream
                    (csocket.getOutputStream());
            for (int i = 100; i >= 0; i--) {
                pstream.println(i +
                        " bottles of beer on the wall");
            }
            pstream.close();
            csocket.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
