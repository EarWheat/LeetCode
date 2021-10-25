package leetcode.History.WordCount;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/*
 * @author:liuzhaolu
 * @createTime: 2020-02-22 20:54
 * @desc:
 */
public class WordCount {
    public static void main(String[] args){
        try {
            File file = new File("../gitUserNameChange");
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = bufferedReader.readLine();
            Map<String, Integer> map = new HashMap<>();
            while (!line.isEmpty()){
                String[] words = line.split(" ");
                for(String word:words){
                    if(map.containsKey(word)){
                        map.put(word,map.get(word) + 1);
                    } else {
                        map.put(word,1);
                    }
                }
                line = bufferedReader.readLine();
            }
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
