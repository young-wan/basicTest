package nowcoder;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/11/22 11:51
 */
public enum EnumT {
    E1("key1", "name1"),
    E2("key2", "name2"),;
    private String key;

    private String name;

    EnumT(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public static void main(String[] args) {
//        int i1 = 1;
//        int i2 = i1;
//        System.out.println(i1);
//        System.out.println(i2);
//        i2 = 2;
//        System.out.println(i1);
//        System.out.println(i2);
//
//        String s1 = "s1";
//        String s2 = s1;
//        System.out.println(s1);
//        System.out.println(s2);
//        s2 = "s2";
//        System.out.println(s1);
//        System.out.println(s2);

        StringBuilder sb1 = new StringBuilder("sb1");
        StringBuilder sb2 = sb1;
        System.out.println(sb1);
        System.out.println(sb2);
        System.out.println("----------");
        sb2.append("222");
        System.out.println(sb1);
        System.out.println(sb2);

    }
}
