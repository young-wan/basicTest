package designPattern.FactoryMethod;

/**
 * @Author: Young
 * @Description:
 * @Date: Created at 9/21 0021 14:47
 */
public class SmsFactory implements Provider {
    public Sender produce() {
        return new SmsSender();
    }
}
