/**
 * @author Young
 * @create 2020-03-03 15:51
 * @desc leetcode
 * {@link}
 **/
public class TestDemo {

    public static void main(String[] args) {
        Snowflake snowflake = new Snowflake();
        for (int i = 0; i < 10; i++) {
            System.out.println(snowflake.snowFlakeGenerate());
        }
    }

}