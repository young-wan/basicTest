package nowcoder;


/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/10/29 17:10
 */
public class Book {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book(String name) {
        this.name = name;
    }

    public <T> void genTest(T x) {
        System.out.println(x.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        Book book = new Book("1");
        book.genTest(1);
        book.genTest("11");
//        Book[] book1 = new Book[5];
//        Book[] book2 = new Book[5];
//        String[] str1 = new String[5];
//        String[] str2 = new String[5];
//        for (int i = 0; i < 5; i++) {
//            book1[i] = new Book("name" + i);
//            book2[i] = new Book("name" + i);
//            str1[i] = "name" + i;
//            str2[i] = new String("name" + i);
//        }
//
//        System.out.println(Arrays.deepToString(book1));
//        System.out.println(Arrays.deepToString(book2));
//        System.out.println(Arrays.deepEquals(book1, book2));
//
//        System.out.println(Arrays.deepToString(str1));
//        System.out.println(Arrays.deepToString(str2));
//        System.out.println(Arrays.equals(str1, str2));

//        List<String> list  = new ArrayList<>(5);
//        System.out.println(list);

//        Random random = new Random(47);
//        System.out.println(random.nextInt(100));
//        System.out.println(random.nextInt(100));
//        System.out.println(random.nextInt(100));


    }
}
