package designPattern.FactoryMethod;

/**
 * @Author: Young
 * @Description:
 * @Date: Created at 9/21 0021 14:48
 */
public class MailFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
