package coding.work;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import sun.jvm.hotspot.utilities.Assert;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-05 15:44
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class FileRead {

    public static List<List<String>> contentToVector(String content, Long length, String filePath){
        long startTime = System.currentTimeMillis();
        System.out.println("startTime:" + startTime);
        List<List<String>> result = new ArrayList<>();
        String[] contents = content.split(" ");
        List<String> words = new ArrayList<>();
        for(int i = 0; i < length; i++){
            if(i < contents.length){
                words.add(contents[i]);
            } else {
                words.add("<PAD>");
            }
        }
        Map<String, String> map = LoadVector(filePath);
//        Map<String, String> map = LoadRemoteVector(filePath);
        for(int i = 0;i < length;i++){
            String temp = map.get(words.get(i));
            if(StringUtils.isNotBlank(temp)){
                result.add(Arrays.asList(temp.split(" ")));
            }
        }
        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;
        System.out.println("costTime:"+costTime);
        return result;
    }

    public static Map<String, String> LoadRemoteVector(String url){
        Map<String, String> map = new HashMap<>();
        try {
            URL remoteUrl = new URL(url);
            InputStream urlInputStream = remoteUrl.openStream();
            InputStreamReader inputStreamReader = new InputStreamReader(urlInputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String s = null;
            while ((s = reader.readLine()) != null){
                String[] keyValue = s.split(" ",2);
                map.put(keyValue[0],keyValue[1]);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    public static Map<String, String> LoadVector(String filePath){
        File file = new File(filePath);
        Map<String, String> map = new HashMap<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String s = null;
            while ((s = reader.readLine()) != null){
                String[] keyValue = s.split(" ",2);
                map.put(keyValue[0],keyValue[1]);
            }
        } catch (FileNotFoundException exception){
            System.out.println("file not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void main(String[] args) {
        String path = "/Users/didi/IdeaProjects/LeetCode/src/main/java/coding/work/w2v_v5.vec";
        String url = "http://106.54.76.130:8080/files/w2v_v5.vec";
        System.out.println("=====================");
        System.out.println(JSONObject.toJSONString(contentToVector("Ligia love Beijing",6L,path)));
//        System.out.println(JSONObject.toJSONString(contentToVector("Ligia love Beijing",6L,url)));
    }
}
