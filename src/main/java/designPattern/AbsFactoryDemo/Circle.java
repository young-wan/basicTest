package designPattern.AbsFactoryDemo;

/**
 * @title: demo
 * @author: Young
 * @desc: 实现Shape接口的具体类-circle
 * @date: Created at 9/6 0006 17:09
 */
public class Circle implements Shape {
    @Override
    public void getShape() {
        System.out.println("this is a circle!");
    }
}
