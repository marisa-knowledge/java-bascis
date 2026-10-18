package List;
import java.util.*;


public class list_demo2 {
    static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");

        printList(list);

        List<String> list2 = new LinkedList<>();
        list2.add("王五");
        list2.add("李六");
        printList(list2);
    }

    public static void printList(List<String> list){
        for(String s : list){
            System.out.println(s);
        }
    }
}
