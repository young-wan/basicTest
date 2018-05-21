package designPattern.FactoryMethod;

import designPattern.FactoryMethod.Sender;

/**
 * @Author: Young
 * @Description:
 * @Date: Created at 9/21 0021 13:54
 */
public class SmsSender implements Sender {
    public void Sender() {
        System.out.println("this is SmsSender!");
    }
}
