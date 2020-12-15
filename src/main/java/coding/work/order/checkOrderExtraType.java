package coding.work.order;

import com.alibaba.fastjson.JSONObject;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-15 10:21
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class checkOrderExtraType {
    public static boolean checkOrderExtraType(Long orderExtraType, String type){
        String extraMappingStr = "{\"o_yuying\":1,\"o_airport\":2,\"o_protect\":3,\"o_train\":4,\"o_cba\":5,\"o_fastcar\":6,\"o_assign\":7,\"o_carpool\":8,\"o_control\":9,\"o_billcfg\":10,\"o_dynamic\":11,\"o_hidemsg\":12,\"o_from_airport\":13,\"o_to_airport\":14,\"o_price_separate\":15,\"o_pricing_new\":16,\"o_bolt\":17,\"o_callcar\":18,\"o_carpool_discount\":19,\"o_carpool_success\":20,\"o_dynamic_separate\":21,\"o_pool_seat\":22,\"o_dest_ride\":23,\"o_serial_order\":24,\"o_taxi_stream\":25,\"o_region\":26,\"o_station_carpool\":27,\"o_booking_assign\":28,\"o_platform_guide\":29,\"o_lineup\":30,\"o_strived_rec\":31,\"o_custom\":32,\"o_ticket\":33,\"o_prepay\":34,\"o_arrangement\":35,\"o_donate\":36,\"o_cyborg_order\":37,\"o_service_order\":38,\"o_both_call_carpool\":39,\"o_fastway\":40,\"o_b2b_callcar\":41,\"o_preauthorization\":42,\"o_stop_carpool\":43}";
        try {
            JSONObject extraArray = JSONObject.parseObject(extraMappingStr);
            if(extraArray.containsKey(type)){
                int index = extraArray.getInteger(type);
                long typeBit = 1 << (index - 1);
                if((orderExtraType & typeBit) == typeBit){
                    return true;
                }
            }
            return false;
        } catch (Exception e){
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(checkOrderExtraType(8439364L,"o_carpool"));
    }
}
