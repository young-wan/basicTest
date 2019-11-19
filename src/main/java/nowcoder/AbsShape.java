package nowcoder;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/11/18 16:23
 */
 abstract class AbsShape {
    void draw(){
        System.out.println(this + ".draw()");
    }
    @Override
    public abstract String toString();

    class Circle1 extends AbsShape{

        @Override
        public String toString() {
            return "circle1";
        }
    }

    class Triangle1 extends AbsShape{

        @Override
        public String toString() {
            return "Triangle1";
        }
    }
}
