package designPattern.FactoryMethod;

/**
 * @Author: Young
 * @Description:
 * @Date: Created at 9/21 0021 13:55
 */
public class FactorySender {
    //  普通工厂模式
    public Sender produce(String type){
        if (type.equals("sms")){
            return new SmsSender();
        }else if (type.equals("mail")){
            return new MailSender();
        }else {
            return null;
        }
    }

    //  多个工厂模式:在工厂类提供多个方法,分别创建对象
    public Sender multipleMail(){
        return new MailSender();
    }

    public Sender multipleSms(){
        return new SmsSender();
    }

    //  将上面的多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可。
    public static Sender staticMail(){
        return new MailSender();
    }

    public static Sender staticSms(){
        return new SmsSender();
    }
}
