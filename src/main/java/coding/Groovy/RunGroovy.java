package coding.Groovy;

import coding.work.test.DetourFeatureHalfCircleJava;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-11 11:38
 * @desc 执行groovy脚本
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class RunGroovy {
    public static void main(String[] args) throws Exception{
//        String str = GroovyException("Hello world");
        String script = readScript("/Users/didi/IdeaProjects/LeetCode/src/main/java/coding/Groovy/GroovyScript");
//        if(StringUtils.isBlank(script)){
//            System.out.println("Groovy script is Empty");
//            return;
//        }
        File file = new File("/Users/didi/IdeaProjects/LeetCode/src/main/java/coding/Groovy/coordinates");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null){
            stringBuilder.append(line);
        }
        file = new File("/Users/didi/IdeaProjects/LeetCode/src/main/java/coding/Groovy/geoPoints");
        fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilderGeo = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null){
            stringBuilderGeo.append(line);
        }
        String coordinates_str = stringBuilder.toString();
        String string_geo_points = stringBuilderGeo.toString();
        Map<String, Object> params = new HashMap<>();
        params.put("order_stage","1");
        params.put("begin_charge_time",1607907688L);
        params.put("coordinates_str", coordinates_str);
        params.put("string_geo_points", string_geo_points);
//        Map<String, Object> params = new HashMap<>();
//        params.put("json","hello world");
//        Object result = GroovyUtil.runGroovyClass(script,params);
//        System.out.println(JSONObject.toJSONString(result));
        String resultStr = DetourFeatureHalfCircleJava.getRaoQuanResult("1",1607907688L,coordinates_str,string_geo_points);
        System.out.println(resultStr);
    }

    /**
     * 读取Groovy脚本文件
     * @param filePath
     * @return
     */
    public static String readScript(String filePath){
        File file;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            file = new File(filePath);
            if(!file.exists()){
                System.out.println("File not found");
                return "";
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            bufferedReader.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }


    public static String GroovyException(String json){
        try {
            JSONObject jsonObject = JSON.parseObject(json);
            return jsonObject.toJSONString();
        } catch (Exception e){
            return e.toString();
        }
    }

}
