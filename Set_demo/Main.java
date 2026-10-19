package Set_demo;

import java.util.*;

public class Main {
    static void main(String[] args) {
        Set<Student> s = new HashSet<>();
        s.add(new Student("张三", 18));
        s.add(new Student("李四", 20));
        s.add(new Student("张三", 18));
        s.add(new Student("王五", 22));
        System.out.println(s.size());
        for (Student student : s) {
            System.out.println(student.getName() + " " + student.getAge());
        }
    }
}
