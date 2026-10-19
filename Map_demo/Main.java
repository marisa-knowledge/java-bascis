package Map_demo;
import java.util.*;

public class Main {
    static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("张三",90);
        map.put("李四",80);
        map.put("王五",95);
        map.put("张三",100);
        System.out.println(map.get("张三"));
        System.out.println(map.get("赵六"));
        System.out.println(map.size());
        for (String key : map.keySet()) {
            Integer value = map.get(key);
            System.out.println(key + " " + value);
        }
    }
}
