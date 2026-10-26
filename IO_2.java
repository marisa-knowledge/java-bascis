import java.io.*;
import java.util.HashMap;

public class IO_2 {
    static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        try(BufferedReader bf = new BufferedReader(new FileReader("article.txt"))){
            String line = bf.readLine();
            while((line = bf.readLine()) != null){
                String[] words = line.split(" ");
                for(String word : words){
                    word = word.toLowerCase();
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }
            }
        }catch (IOException e){
            System.out.println("读取文件出错" + e.getMessage());
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt"))){
            for(String word : map.keySet()){
                bw.write(word + " " + map.get(word));
                bw.newLine();
            }
        }catch (IOException e){
            System.out.println("写入文件出错" + e.getMessage());
        }
    }
}
