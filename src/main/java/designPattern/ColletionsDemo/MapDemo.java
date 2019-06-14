package designPattern.ColletionsDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 10/25 0025 16:07
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("CSS", "style");
        map.put("HTML", "mark up");
        map.put("Oracle", "database");
        map.put("XML", "data");

        // Get the entry Set
        Set<Map.Entry<String, String>> entries = map.entrySet();

        entries.forEach((Map.Entry<String, String> entry)->{
            System.out.println(entry);
        });

        entries.forEach((e)->{
            System.out.println(e);
//            String key = e.getKey();
//            String value = e.getValue();
//            System.out.println("key: " + key + " value: " + value);
        });

        map.forEach((key, value)->{
            System.out.println(key);
            System.out.println(value);
        });

        SortedMap<String, String> sMap = new TreeMap<>();
        sMap.put("CSS", "style");
        sMap.put("XML", "data");
        sMap.put("HTML", "mark up");
        sMap.put("Oracle", "database");
        System.out.println(sMap);

    }

}
