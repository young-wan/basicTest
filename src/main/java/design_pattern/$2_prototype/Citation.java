package design_pattern.$2_prototype;

/**
 * @Author young
 * @Date 2020/5/21 9:50
 * @Desc
 **/
public class Citation implements Cloneable {
    String name;

    String info;

    String college;

    public Citation(String name, String info, String college) {
        this.name = name;
        this.info = info;
        this.college = college;
        System.out.println("奖状创建成功");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void show() {
        System.out.println(name + info + college);
    }

    @Override
    protected Citation clone() throws CloneNotSupportedException {
        System.out.println("奖状拷贝成功！");
        return (Citation) super.clone();
    }
}

class CitationTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Citation c1 = new Citation("张三", "同学：在2016学年第一学期中表现优秀，被评为三好学生。", "韶关学院");
        c1.show();
        Citation c2 = c1.clone();
        c2.setName("李思");
        c2.show();
    }

}
