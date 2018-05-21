package wechat.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wechat.module.TestModule;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: Young
 * @Description:
 * @Date: Created at 9/20 0020 16:56
 */
@Service
@Transactional
public class TestService {

    public static void main (String[] args) throws IOException {
        TestService ts = new TestService();
        ts.ObjectStreamTest();

    }

    public static void valueTest(){
        int a = 0;
        int b = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a number : ");
        a = scanner.nextInt();
        b = scanner.nextInt();
        if (a > b){
            System.out.println("a is max");
        }else if (a < b){
            System.out.println(" b is max");
        }else {
            System.out.println(" a = b");
        }
    }

    /**
     * 读写对象：ObjectInputStream 和ObjectOutputStream ，该流允许读取或写入用户自定义的类，
     * 但是要实现这种功能，被读取和写入的类必须实现Serializable接口，其实该接口并没有什么方法，可能相当于一个标记而已，但是确实不合缺少的。
     */
    public void ObjectStreamTest(){
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        File f = new File("C:\\Users\\Administrator\\Desktop\\accessToken.txt");
        try {
            oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(new TestModule("token1", 1));
            oos.writeObject(new TestModule("token2", 2));
            ois = new ObjectInputStream(new FileInputStream(f));
            for (int i = 0; i < 2; i++){
                System.out.println(ois.readObject());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void IOTest() {
        //指定文件存放路径
        File f = new File("C:\\Users\\Administrator\\Desktop\\test.txt");
        //  当且仅当不存在具有此抽象路径名指定名称的文件时，不可分地创建一个新的空文件。
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(f.getAbsolutePath());


        int count = 0;
        //一次取出的字节数大小,缓冲区大小
        byte[] buffer = new byte[1024];
        //文件输入流
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\file.txt");
            outputStream = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\file3.txt");
            while (inputStream.read(buffer) != -1){
                count++;
                outputStream.write(buffer, 0, buffer.length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void mapTest() {
        Map<String, String> map = new LinkedHashMap<String, String>();
        map.put("k-a", "v-a");
        map.put("k-b", "v-b");
        map.put("k-c", "v-c");
//        System.out.println(map.entrySet());
//        System.out.println(map.get("k-c"));
//        System.out.println(map.keySet());
//        System.out.println(map.values());

        Iterator it = map.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
            System.out.println(i + " key = " + entry.getKey() + " and value = " + entry.getValue());
            i++;
        }

        /**
         * HashMap, LinkedHashMap, Hashtable, TreeMap
         */
    }

    public void StringBufferTest(){
        StringBuffer sb = new StringBuffer();
        sb.append("1");
        sb.append("鸟");
        sb.charAt(1);
        System.out.println(sb.toString());
        System.out.println(sb.reverse());
    }
}
