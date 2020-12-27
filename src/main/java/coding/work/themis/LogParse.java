package coding.work.themis;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-25 17:32
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class LogParse {
    public static void main(String[] args) {
        String inputString = "final_result_passenger_event_type=||trace_id=79384f985fe5bb1a00000b9957541dd2||role=driver||cancel_step=cancel_step_cancel||dynamic_cancel_fee=0||final_result_driver_event_type=||opera_stat_key=g_themis_public_log_key_service_control||final_result_duty=0||final_result_penalty=0||product_id=16||district=01161||scene_code=30001||final_result_compensate_driver_info={\"empty_drive_compensate\":0,\"empty_drive_compensation_switch\":1,\"empty_drive_compensate_status\":2,\"empty_drive_compensate_pay_role\":2,\"empty_drive_compensation_passenger_pay_fee\":0,\"empty_drive_compensation_platform_pay_fee\":0,\"empty_drive_compensation_platform_pay_role\":2,\"empty_drive_compensation_empty_distance\":0}||order_id=87973171150040||final_result_is_forbidden=0||timestamp=2020-12-25 18:12:43||final_result_reassign_event_type=driver_reassign_danger_order_no_duty||final_result_reassign_passenger_event_type=driver_not_late_not_arrive";
        String[] keyAndValue = inputString.split("\\|\\|");
        Map<String, String> json = new HashMap<>();
        for(String str: keyAndValue){
            String[] temp = str.split("=");
            if(temp.length == 1){
                json.put(temp[0],"");
            } else {
                json.put(temp[0],temp[1]);
            }
        }
        String result = JSONObject.toJSONString(json);
        System.out.println(result);
    }
}
