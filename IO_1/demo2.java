package IO_1;

import java.io.*;

public class demo2 {
    static void main(String[] args) {
        System.out.println("=====开始写入 作业.txt =====");
        try{
            FileWriter writer = new FileWriter("作业.txt");
            writer.write("原您的旨意");
            writer.write("\n行在地上");
            writer.write("\n如同行在天上");
            writer.close();
        }catch(IOException e){
            System.out.println("写入文件时出错" + e.getMessage());
        }

        System.out.println("=====开始读取 作业.txt =====");
        try {
            FileReader reader = new FileReader("作业.txt");
            int ch;
            while((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }
            reader.close();
        }catch (IOException e){
            System.out.println("读取文件时出错" + e.getMessage());
        }
    }
}
