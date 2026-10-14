package core_api_01;

import java.util.ArrayList;

public class Arraylist_demo1 {
    static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        System.out.println(list);

        boolean res = list.add("qqq");
        System.out.println(res);

        System.out.println(list);

        list.add(0,"www");
        System.out.println(list);

        String res1 = list.remove(0);
        System.out.println(res1);

        System.out.println(list);

        boolean res2 = list.remove("qqq");
        System.out.println(res2);

        System.out.println(list);

        String res3 = list.set(0,"www");
        System.out.println(res3);

        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
