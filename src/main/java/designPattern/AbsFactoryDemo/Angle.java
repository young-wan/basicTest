package designPattern.AbsFactoryDemo;

/**
 * @title: demo
 * @author: Young
 * @desc: 实现Shape接口的具体类-angle
 * @date: Created at 9/6 0006 17:09
 */
public class Angle implements Shape {
    @Override
    public void getShape() {
        System.out.println("this is an angle!");
    }
}
