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
            JSONObject temp = jsonObject;
            for (int i = 0; i < keys.length - 1; i++) {
                temp = temp.getJSONObject(keys[i]);
            }
            return temp.get(keys[keys.length - 1]);
        } catch (Exception e){
            return "";
        }
    }

    public static void main(String[] args) {
        String str = "{\"__experiment\":{\"experiment_group\":\"treatment_group\",\"experiment_key\":\"ar_cr_under_certain_dsr_tail_driver_v2\",\"experiment_params\":\"\"},\"category\":0,\"city_id\":55000199,\"country_code\":\"BR\",\"county_id\":0,\"product_id\":0,\"sync_id\":94812,\"weekly_acceptance\":{\"control_config\":{\"grap_order_num\":7,\"punish_threshold\":10,\"warning_threshold\":20},\"meta_data\":{\"open\":true},\"punish_config\":{\"level_1\":24,\"level_2\":72,\"level_3\":168,\"open\":true}},\"weekly_complete\":{\"control_config\":{\"grap_order_num\":7,\"punish_threshold\":10,\"warning_threshold\":20},\"meta_data\":{\"open\":true},\"punish_config\":{\"level_1\":24,\"level_2\":72,\"level_3\":168,\"open\":true}}}";
        System.out.println(getKeyUseJsonPath(str,"weekly_acceptance.punish_config.open"));
    }
}
