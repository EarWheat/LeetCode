package coding.work;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-23 17:48
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class parseJsonByKey {
    public static String parseJsonByKey(String data, String key) {
        if (StringUtils.isEmpty(data) || StringUtils.isEmpty(key)) {
            return "";
        }
        JSONArray jsonArray = JSONArray.parseArray(data);
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < jsonArray.size();i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            if(jsonObject.containsKey(key)){
                stringBuilder.append(jsonObject.getString(key));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(parseJsonByKey("[{\"channel_id\":150,\"amount\":586,\"card_index\":\"244036\"}]","channel_id")));
    }
}
