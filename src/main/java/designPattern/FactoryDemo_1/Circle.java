package designPattern.FactoryDemo_1;

/**
 * @title: wechat-service
 * @author: Young
 * @desc: 微信
 * @date: Created at 9/6 0006 16:38
 */
public class Circle implements Shape {
    @Override
    public void getShape() {
        System.out.println("this is a circle shape!");
    }
}
