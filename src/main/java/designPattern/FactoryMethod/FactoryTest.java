package designPattern.FactoryMethod;

import designPattern.Singleton.Singleton;

/**
 * @Author: Young
 * @Description:
 * @Date: Created at 9/21 0021 14:45
 */
public class FactoryTest {
    public static void main(String[] args) {
//        FactorySender factorySender = new FactorySender();
//        Sender sender = factorySender.produce("sms");     普通工厂模式
//        Sender sender = factorySender.multipleMail();      多个工厂模式
//        Sender sender = FactorySender.staticMail();          静态工厂模式
//        sender.Sender();
        Provider provider = new SmsFactory();
        Sender sender = provider.produce();
        sender.Sender();
    }
}
