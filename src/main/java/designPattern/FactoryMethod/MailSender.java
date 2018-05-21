package designPattern.FactoryMethod;

import designPattern.FactoryMethod.Sender;

/**
 * @Author: Young
 * @Description:
 * @Date: Created at 9/21 0021 13:53
 */
public class MailSender implements Sender {
    public void Sender() {
        System.out.println("this is mailsend!");
    }
}
