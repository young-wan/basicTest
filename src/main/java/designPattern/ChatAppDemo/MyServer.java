package designPattern.ChatAppDemo;

import com.google.common.base.Strings;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @title: wechat-service
 * @author: Young
 * @desc: 微信
 * @date: Created at 8/31 0031 10:33
 */
public class MyServer extends JFrame implements ActionListener, Runnable {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jbt = (JButton) e.getSource();
        if (jbt == jbtn) {
            changeFlag(true);
        }

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                if (flags) {
                    changeFlag(false);
                    String str = jTextSend.getText().trim();
                    if (Strings.isNullOrEmpty(str)) {

                    } else {
                        dos.writeUTF(str);
                        dos.flush();
                        jTextReceive.append("服务器端发送消息: " + str + "\n");
                        jTextSend.setText("");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void finalize() //析构方法
    {
        try {
            server.close();
        } //停止ServerSocket服务
        catch (IOException e) {
            System.out.println(e);
        }
    }


    JTextArea jTextReceive = new JTextArea();
    JTextField jTextSend = new JTextField();
    JButton jbtn = new JButton("发送");
    ServerSocket server = null;
    JScrollPane jScrollPane = new JScrollPane(jTextReceive);
    Socket clientSocket;
    boolean flag = true;

    Thread connenThread;
    BufferedReader brin;
    DataInputStream dis;
    DataOutputStream dos;
    boolean flags = false;

    public static void main(String[] args) {
        MyServer ms = new MyServer();
        ms.serverStart();

    }

    public synchronized void changeFlag(boolean b) {
        flags = b;
    }

    public void serverStart() {
        try {
            server = new ServerSocket(8080);
            this.setTitle("服务器端,端口号: " + server.getLocalPort());
            this.setLayout(null);
            this.setBounds(20, 00, 300, 300);
            jScrollPane.setBounds(20, 20, 220, 100);
            jTextSend.setBounds(20, 120, 220, 50);
            jbtn.setBounds(20, 170, 220, 30);
            this.add(jScrollPane);
            this.add(jTextSend);
            this.add(jbtn);
            this.setVisible(true);
            jbtn.addActionListener(this);

            while (flag) {
                clientSocket = server.accept();
                jTextReceive.setText("连接已经建立完毕!\n");
                InputStream is = clientSocket.getInputStream();
                brin = new BufferedReader(new InputStreamReader(is));
                OutputStream os = clientSocket.getOutputStream();
                dis = new DataInputStream(clientSocket.getInputStream());
                dos = new DataOutputStream(os);
                connenThread = new Thread(this);
                connenThread.start();
                String aLine;
                while (true) {
                    aLine = dis.readUTF();
                    jTextReceive.append("客户端发来消息: " + aLine + "\n");
                    if (aLine.equals("bye")) {
                        flag = false;
                        connenThread.interrupt();
                        break;
                    }
                }
                dos.close();
            }
            brin.close();
            clientSocket.close();
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
