package designPattern.ClassDemo;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 10/23 0023 11:35
 */
public class MyClass implements Cloneable {

    public String id;

    public String name;

    public String tele;

    private String t = "test";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", tele='" + tele + '\'' +
                '}';
    }


    @Override
    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        MyClass mc = new MyClass();
        Class c = mc.getClass();
        Class<MyClass> cc = MyClass.class;
        System.out.println(c == cc);

        System.out.println(c.getSimpleName());
        c.getSimpleName();
        System.out.println(Modifier.toString(c.getModifiers()));
        System.out.println(c.getModifiers());
        System.out.println(c.getSuperclass());
        Class[] interfaces = c.getInterfaces();
        for (Class ci : interfaces) {
            System.out.println(ci.getSimpleName());
        }
        int a = 0;
        int PUBLIC = 0x00000001;
        a = 0 & PUBLIC;
        System.out.println("a: " + (1 & PUBLIC));
        Field[] fields = c.getFields();
        System.out.println(fields.length);
        for (Field f : fields) {
            System.out.println(f.getName());
            System.out.println(f.getType().getSimpleName());
        }
        System.out.println(c.getConstructors());
        c.getTypeParameters();

        MyClass m1 = (MyClass) c.newInstance();
        MyClass m2 = (MyClass) cc.newInstance();
        System.out.println(m1.getClass().getSimpleName());
        System.out.println(m2.getClass().getSimpleName());

        System.out.println("-----------------------");
        Field f = c.getDeclaredField("t");
//        f.setAccessible(true);
        String f1 = (String) f.get(m1);
        System.out.println("fff: " + f + "value: " + f1);


        MyClass tm = cc.newInstance();
        Field name = cc.getDeclaredField("t");
        String nameV = (String) name.get(tm);
        System.out.println("old value is : " + nameV);
        name.set(tm, "ttt");
        String nameVV = (String) name.get(tm);
        System.out.println("now value is : " + nameVV);

        int[] ids = (int[]) Array.newInstance(int.class, 5);
        int i1 = Array.getInt(ids, 1);
        int i2 = Array.getInt(ids, 2);
        System.out.println("i1: " + i1 + " i2: " + i2);

        System.out.println(Arrays.toString(ids));
        Array.setInt(ids, 0, 11);
        Array.setInt(ids, 1, 22);
        i1 = Array.getInt(ids, 1);
        i2 = Array.getInt(ids, 2);
        System.out.println("i1: " + i1 + " i2: " + i2);
        System.out.println(Arrays.toString(ids));
        int[][][] intArray = new int[1][2][3];
        Class ccc = intArray.getClass();

    }
}
