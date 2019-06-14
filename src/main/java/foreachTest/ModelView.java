package foreachTest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 5/22 0022 14:05
 */
public class ModelView {

    private String id;

    private String name;

    private String content;

    private List<ModelView> list;

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    private void setContent(String content) {
        this.content = content;
    }

    public List<ModelView> getList() {
        return list;
    }

    public void setList(List<ModelView> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ModelView{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", list=" + list +
                '}';
    }

    public static void main(String[] args) {
        List<ModelView> list = new ArrayList<>();
        ModelView lv = new ModelView();
        lv.setId("listid");
        lv.setName("listNmae");
        list.add(lv);
        ModelView mv = new ModelView();
        mv.setId("id1");
        mv.setName("name");
        mv.setList(list);
        System.out.println(mv.toString().hashCode());

        List<ModelView> list2 = new ArrayList<>();
        ModelView lv2 = new ModelView();
        lv2.setId("listid11");
        lv2.setName("listNmae");
        list2.add(lv2);

        ModelView mv2 = new ModelView();
        mv2.setId("id1");
        mv2.setName("name");
        mv2.setList(list2);
        System.out.println(mv2.toString().hashCode());


        System.out.println(mv.toString().hashCode());
        System.out.println(mv2.toString().hashCode());
        System.out.println((mv.toString().hashCode()) == (mv2.toString().hashCode()));
    }

    private static List<ModelView> for1() {
        Long long1 = System.currentTimeMillis();
        List<ModelView> modelViews = new ArrayList<>();
        ModelView mv = null;
        for (int i = 0; i < 10; i++) {
            mv = new ModelView();
            mv.setId(String.valueOf(i));
            mv.setName(String.valueOf(i) + "name");
            mv.setContent(String.valueOf(i) + "content");
            modelViews.add(mv);
        }
        Long long2 = System.currentTimeMillis();
        System.out.println("1---------" + (long1 - long2));
        return modelViews;
    }

    private static List<ModelView> for2() {
        Long long1 = System.currentTimeMillis();
        List<ModelView> modelViews = new ArrayList<>();
        ModelView mv = new ModelView();
        for (int i = 0; i < 10; i++) {
            mv.setId(String.valueOf(i));
            mv.setName(String.valueOf(i) + "name");
            mv.setContent(String.valueOf(i) + "content");
            modelViews.add(mv);
        }
        Long long2 = System.currentTimeMillis();
        System.out.println("2---------" + (long1 - long2));
        return modelViews;
    }

    private static List<ModelView> for3() {
        Long long1 = System.currentTimeMillis();
        List<ModelView> modelViews = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ModelView mv = new ModelView();
            mv.setId(String.valueOf(i));
            mv.setName(String.valueOf(i) + "name");
            mv.setContent(String.valueOf(i) + "content");
            modelViews.add(mv);
        }
        Long long2 = System.currentTimeMillis();
        System.out.println("3---------" + (long1 - long2));
        return modelViews;
    }
}

