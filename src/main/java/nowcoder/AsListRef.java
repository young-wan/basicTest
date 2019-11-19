package nowcoder;

import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.TreeMap;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/11/11 15:39
 */
public class AsListRef {
    public static void main(String[] args) {
        Random random = new Random(47);
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < 10000; i++) {
            Integer c = random.nextInt(20);
            Integer res = map.get(c);
            map.put(c, Objects.isNull(res) ? 1 : res + 1);
        }
        System.out.println(map);
        System.out.println(map.entrySet());
        System.out.println(map.keySet());
        System.out.println(map.values());
    }
}

class Snow {

}

class Powder extends Snow {

}

class Light extends Powder {

}

class Heavy extends Powder {

}

class Crusty extends Snow {

}

class Slush extends Snow {

}
