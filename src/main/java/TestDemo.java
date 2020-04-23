import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Young
 * @create 2020-03-03 15:51
 * @desc leetcode
 * {@link}
 **/
public class TestDemo {

    public static void main(String[] args) {
        List<String> strs = new ArrayList<String>(16);
        List<Integer> ints = new ArrayList<Integer>(16);
        List<Map<String, Object>> maps = new ArrayList<>(16);
        System.out.printf("%s,%s,%s,%s", strs.size(), strs.getClass() == ints.getClass(), Objects.equals(strs.getClass(), maps.getClass()), List.class.getSimpleName() == "List");
    }

}
