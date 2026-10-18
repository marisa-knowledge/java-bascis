package List;
import java.util.*;

public class list_demo {
    static void main(String[] args) {
        List<String> queue = new ArrayList<>();
        queue.add("小红");
        queue.add("小明");
        queue.add("小刚");
        queue.add(1,"土豪");
        queue.get(0);
        queue.remove(2);
        for(String s : queue){
            System.out.println(s);
        }

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("中间人");

        linkedList.addFirst("第一人");

        linkedList.addLast("最后人");

        System.out.println("现在的队伍：" + linkedList);

        linkedList.removeFirst();
        System.out.println("走了一个后队伍：" + linkedList);
    }
}
