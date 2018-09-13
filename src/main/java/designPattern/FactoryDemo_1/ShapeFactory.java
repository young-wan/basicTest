package designPattern.FactoryDemo_1;

/**
 * @title: wechat-service
 * @author: Young
 * @desc: 微信
 * @date: Created at 9/6 0006 16:40
 */
public class ShapeFactory {
    private String shape;

    public  ShapeFactory(){
        System.out.println("cons");
    }

    public Shape ShapeFactory(String shape){
        if (shape.equals("circle")){
            return new Circle();
        }
        if (shape.equals("angle")){
            return new Angle();
        }
        return null;
    }

    public static void main(String[] args) {
        ShapeFactory shape = new ShapeFactory();
        Shape shape1 = shape.ShapeFactory("circle");
        shape1.getShape();
        Shape shape2 = shape.ShapeFactory("angle");
        shape2.getShape();
    }
}
