package IO_1;

import java.io.*;

    public class demo1 {
        public static void main(String[] args) {
            System.out.println("-----开始读取 test.txt-----");
            try{
                FileReader reader = new FileReader("test.txt");
                int ch;
                while((ch = reader.read()) != -1){
                    System.out.print((char)ch);
                }
                reader.close();
            }catch(IOException e){
                System.out.println("读取文件时出错" + e.getMessage());
            }


            System.out.println("\n-----开始写入 copy.txt-----");
            try{
                FileWriter writer = new FileWriter("copy.txt");
                writer.write("JAVA IO测试成功");
                writer.write("\n第二行内容");
                writer.close();
            }catch(IOException e){
                System.out.println("写入文件时出错" + e.getMessage());
            }
        }
    }
