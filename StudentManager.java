package Collectiong_03;
import java.util.*;

class Student{
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return "Student{" + "name = " + name + ", age = " + age + "}";
    }

    @Override
    public boolean equals(Object obj){
        if( this == obj){
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        }else{
            Student student = (Student)obj;
            return Objects.equals(name, student.name) && age == student.age;
        }
    }
}

public class StudentManager {
    static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("张三", 18));
        list.add(new Student("李四", 20));
        list.add(new Student("王五", 21));
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().equals("王五")){
                list.get(i).setAge(22);
            }
        }

        System.out.println(list);


        list.remove(new Student("李四", 20));
        System.out.println(list);


        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName() + " " + list.get(i).getAge());
        }
    }

}
