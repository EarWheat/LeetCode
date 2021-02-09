package coding;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.kafka.connect.data.Decimal;

import java.math.BigDecimal;

/*
 * @author:liuzhaolu
 * @createTime: 2019-10-24 17:25
 * @desc:
 */
public class Main {
    public static String getValByCodeFromJsonNew(String kvJson, String code) {
        if (StringUtils.isBlank(kvJson) || StringUtils.isBlank(code)) {
            return null;
        }
        JSONObject json = JSONObject.parseObject(kvJson);

        if(json.containsKey(code)) {
            return json.getString(code);
        }
        return null;
    }

    public static void main(String[] args) {
        String json = "{\"min_completion_rate\":0.65,\"level_two_ban_time\":3,\"level_three_ban_time\":7,\"level_one_ban_time\":1,\"level_four_ban_time\":7,\"completion_rate_control_switch\":1}";
        String code = "min_completion_rate";
        System.out.println(getValByCodeFromJsonNew(json,code));
    }


    /**
     * war计算
     * @param war
     * @param threshold
     * @param needControl 是否需要管控，包含
     * @param lastLevel
     * @param lastPunishDay
     * @return
     */
    public Long getWarPunishLevel(BigDecimal war, BigDecimal threshold, Boolean needControl, Long lastLevel, Long lastPunishDay, Long punishTimes){
        if(!needControl){
            return -2L;
        }
        // 达标
        if(war.compareTo(threshold) > 0){
            return 0L;
        } else {    // 不达标
            if(punishTimes == 0L){  // 首次处置
                return -1L;
            } else {    // 非首次处置
                if(lastPunishDay >= 7){
                    return -2L;
                } else {
                    if(lastLevel == -1L){   // 首次之后是level1
                        return 1L;
                    }
                    return lastLevel + 1;
                }
            }
        }
    }
}
