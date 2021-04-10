package coding.MyTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/4/9 上午11:39
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class getKeyUseJsonPath {
    public static Object getKeyUseJsonPath(String json, String path){
        try {
            JSONObject jsonObject = JSON.parseObject(json);
            String[] keys = path.split("\\.");
            JSONObject temp = new JSONObject();
            for (int i = 0; i < keys.length - 1; i++) {
                temp = jsonObject.getJSONObject(keys[i]);
            }
            return temp.get(keys[keys.length - 1]);
        } catch (Exception e){
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(getKeyUseJsonPath("{\"punish_config\":{\"level_3\":36,\"level_1\":12,\"level_2\":24},\"meta_data\":{\"open\":true},\"control_config\":{\"grap_order_num\":7,\"punish_threshold\":10,\"warning_threshold\":20}}","control_config.grap_order_num"));
    }
}
