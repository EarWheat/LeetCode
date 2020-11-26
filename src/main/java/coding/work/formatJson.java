package coding.work;

import com.alibaba.fastjson.JSONObject;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-26 10:35
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class formatJson {

    public static String param2JSON(String... str){
        if(str.length % 2 != 0){
            return null;
        }
        JSONObject jsonObject = new JSONObject();
        int i = 0;
        while (i < str.length){
            jsonObject.put(str[i],str[i+1]);
            i = i+2;
        }
        return jsonObject.toJSONString();
    }

    public static void main(String[] args) {
        System.out.println(param2JSON(null,null,null,null,"hello","world"));
    }
}
