package coding.work.newtonGroovy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/1/13 下午2:07
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class getWhereBetween {
    public static String getWhereBetween(String key, Long index){
        LocalDate now = LocalDate.now();
        LocalDate endTime = now.plusMonths(index);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        if(index > 0){
            jsonArray.add(formatter.format(now).concat(" 00:00:00"));
            jsonArray.add(formatter.format(endTime).concat(" 23:59:59"));
        } else {
            jsonArray.add(formatter.format(endTime).concat(" 00:00:00"));
            jsonArray.add(formatter.format(now).concat(" 23:59:59"));
        }
        jsonObject.put(key,jsonArray);
        return jsonObject.toJSONString();
    }

    public static String getLimit(Long offset, Long page){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("offset",offset);
        jsonObject.put("page",page);
        return jsonObject.toJSONString();
    }

    public static List<String> getCashOrderIdList(String orderList, Long Limit){
        List<String> result = new ArrayList<>();
        if (StringUtils.isBlank(orderList)) {
            return result;
        }
        try {
            JSONArray jsonArray = JSONArray.parseArray(orderList);
            int index = 0;
            for(int i = 0; i < jsonArray.size(); i++){
                if(index > Limit){
                    break;
                }
                JSONObject object = jsonArray.getJSONObject(i);
                if(object.containsKey("pay_type") && (object.getString("pay_type").equals("1024")
                        || object.getString("pay_type").equals("2048") || object.getString("pay_type").equals("4096"))){
                    result.add(object.getString("order_id"));
                    index++;
                }
            }
        } catch (Exception e){
            return result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getWhereBetween("departure_time",-6L));
        String test = "[{\"_birth_time\":\"2021-01-13 07:44:56\",\"_create_time\":\"2021-01-13 07:44:58\",\"_modify_time\":\"2021-01-13 07:46:13\",\"_modify_time_ns\":\"0\",\"_status\":\"1\",\"actual_level\":\"0\",\"additional_cap_price\":\"0\",\"additional_charge\":\"0\",\"additional_estimate_fixed_fees\":\"\",\"additional_estimate_id\":\"0\",\"additional_pre_total_fee\":\"0\",\"airport_type\":\"0\",\"approach_airport\":\"0\",\"approach_railway\":\"0\",\"area\":\"61020600\",\"arrive_time\":\"0000-00-00 00:00:00\",\"assign_company_type\":\"0\",\"assign_type\":\"1\",\"assigned_lat\":\"-37.723557\",\"assigned_lng\":\"144.849696\",\"assigned_time\":\"2021-01-13 07:45:16\",\"balance_chn\":\"0\",\"begin_charge_lat\":\"0.000000\",\"begin_charge_lng\":\"0.000000\",\"begin_charge_time\":\"0000-00-00 00:00:00\",\"begun_lat\":\"0.000000\",\"begun_lng\":\"0.000000\",\"begun_time\":\"0000-00-00 00:00:00\",\"bigc_info\":\"\",\"biz_ticket\":\"\",\"blind_type\":\"0\",\"booking_assign\":\"0\",\"bouns\":\"0\",\"business_id\":\"21042\",\"call_car\":\"0\",\"call_times\":\"1\",\"callcar_name\":\"\",\"cancelled_lat\":\"0.000000\",\"cancelled_lng\":\"0.000000\",\"cancelled_time\":\"2021-01-13 07:46:13\",\"cap_chn\":\"0\",\"cap_price\":\"7.30\",\"capacity_level\":\"21042\",\"car_id\":\"360287970195384211\",\"car_ticket\":\"0\",\"card_type\":\"\",\"carpool_contract_driver\":\"0\",\"carpool_long_order\":\"0\",\"carpool_order_scene\":\"-1\",\"carpool_price_type\":\"0\",\"carpool_type\":\"0\",\"channel\":\"102\",\"chengyidan_type\":\"0\",\"close_reason\":\"0\",\"combo_distance\":\"0.00\",\"combo_fee\":\"0.00\",\"combo_id\":\"0\",\"combo_time\":\"0\",\"combo_type\":\"0\",\"commercial_type\":\"0\",\"company_group_ids\":\"\",\"complete_type\":\"4\",\"completed_lat\":\"0.000000\",\"completed_lng\":\"0.000000\",\"completed_time\":\"0000-00-00 00:00:00\",\"compress_type\":\"0\",\"consult_min\":\"15\",\"consult_status\":\"1\",\"consult_time\":\"2021-01-13 08:00:16\",\"contract_type\":\"0\",\"cooperation_id\":\"0\",\"coordinate_type\":\"2\",\"count_price_type\":\"2\",\"country_iso_code\":\"AU\",\"county\":\"61020619\",\"coupon_chn\":\"0\",\"coupon_info\":\"[]\",\"current_lat\":\"-37.713941\",\"current_lng\":\"144.888589\",\"custom_service\":\"0\",\"d_sub_id\":\"0\",\"delay_time_start\":\"0000-00-00 00:00:00\",\"departure_recommend\":\"0\",\"departure_time\":\"2021-01-13 07:44:56\",\"dest_commercial_area\":\"\",\"dest_lat\":\"-37.733334\",\"dest_lng\":\"144.866792\",\"dest_name\":\"13 Centreway, Keilor East VIC 3033, Australia\",\"dest_poi_id\":\"ChIJkV8s96Ve1moRFNJz6XRAmnc\",\"dest_tag\":\"0\",\"destination_fixed\":\"0\",\"disability_type\":\"0\",\"discount_chn\":\"0\",\"dispatch_driver_type\":\"0\",\"distance\":\"0.0\",\"district\":\"02522\",\"driver_display_price\":\"6.00\",\"driver_dynamic_times\":\"0\",\"driver_estimate_price\":\"0\",\"driver_id\":\"650910926653871\",\"driver_phone\":\"434867041\",\"driver_product_id\":\"21042\",\"driver_snapshot\":\"\",\"driver_start_distance\":\"6553\",\"driver_stock_out_time\":\"\",\"driver_type\":\"1\",\"dual_nocarpool_estimate_id\":\"\",\"duse_march_mode\":\"0\",\"dynamic_price\":\"0\",\"emergency_service_type\":\"0\",\"end_charge_lat\":\"0.000000\",\"end_charge_lng\":\"0.000000\",\"enterprise_flag\":\"0\",\"estimate_fixed_fees\":\"[{\\\"name\\\":\\\"commission_fee\\\",\\\"value\\\":0.55,\\\"quantity_unit\\\":\\\"\\\"},{\\\"name\\\":\\\"levy_fee\\\",\\\"value\\\":1.1,\\\"quantity_unit\\\":\\\"\\\"}]\",\"estimate_id\":\"148f8a553fe9025647d2c17656b29282\",\"estimate_time\":\"9\",\"ext_driver_id\":\"\",\"ext_order_id\":\"\",\"ext_sub_product_id\":\"0\",\"extend_feature\":\"{\\\"estimate_info\\\":{\\\"estimate_fixed_fees\\\":\\\"[{\\\\\\\"name\\\\\\\":\\\\\\\"commission_fee\\\\\\\",\\\\\\\"value\\\\\\\":0.55,\\\\\\\"quantity_unit\\\\\\\":\\\\\\\"\\\\\\\"},{\\\\\\\"name\\\\\\\":\\\\\\\"levy_fee\\\\\\\",\\\\\\\"value\\\\\\\":1.1,\\\\\\\"quantity_unit\\\\\\\":\\\\\\\"\\\\\\\"}]\\\",\\\"fixed_preferential\\\":0,\\\"red_packet\\\":-1},\\\"neworder_info\\\":{\\\"is_region\\\":0,\\\"platform_type\\\":1}}\",\"extra_info\":\"{\\\"pre_payment\\\":895,\\\"card_index\\\":\\\"218792\\\",\\\"user_ip\\\":\\\"49.199.212.203\\\"}\",\"extra_type\":\"2199023305540\",\"finish_time\":\"0000-00-00 00:00:00\",\"finished_lat\":\"0.000000\",\"finished_lng\":\"0.000000\",\"finished_time\":\"0000-00-00 00:00:00\",\"fixed_price_type\":\"0\",\"free_chn\":\"0\",\"freeze_source\":\"0\",\"freeze_status\":\"0\",\"from_address\":\"7 Dromana Ave, Airport West VIC 3042, Australia\",\"from_name\":\"7 Dromana Ave\",\"geofencing\":\"0\",\"global_order_id\":\"\",\"gulfstream_ahead_assigned\":\"\",\"gulfstream_guide_scene\":\"\",\"gulfstream_last_order_id\":\"\",\"haolidan_type\":\"0\",\"hotel_type\":\"0\",\"input\":\"1\",\"international_signpost\":\"{\\\"airportRide\\\":0,\\\"functions\\\":{\\\"price_mode\\\":3}}\",\"invitation_type\":\"0\",\"is_accurate_order\":\"0\",\"is_anycar\":\"0\",\"is_cancel_comment\":\"1\",\"is_carpool_success\":\"0\",\"is_down_accept\":\"0\",\"is_dual_carpool_price\":\"0\",\"is_female_travel\":\"0\",\"is_pay\":\"0\",\"is_platform_paid\":\"0\",\"is_rainbow\":\"0\",\"is_semi_assign\":\"0\",\"is_short_book\":\"0\",\"is_social_security_driver\":\"0\",\"is_special_price\":\"0\",\"is_special_rate\":\"0\",\"is_split_fare\":\"0\",\"level\":\"0\",\"level_type\":\"0\",\"line_up\":\"0\",\"local_currency\":\"AUD\",\"local_time_zone\":\"660\",\"long_rent_type\":\"0\",\"loss_remand\":\"0\",\"menu_id\":\"\",\"mixed_payment_info\":\"\",\"new_lat\":\"-37.713941\",\"new_lng\":\"144.888589\",\"new_time\":\"2021-01-13 07:44:56\",\"offline_pay_status\":\"0\",\"order_id\":\"87973531345031\",\"order_status\":\"7\",\"original_passenger_count\":\"0\",\"p_sub_id\":\"0\",\"pangu_max\":\"0.00\",\"pangu_times\":\"0.00\",\"partner_id\":\"0\",\"passenger_count\":\"0\",\"passenger_id\":\"87961032049139\",\"passenger_phone\":\"+61432787031\",\"pay_type\":\"256\",\"pbd_ext_oid\":\"\",\"pbd_oid\":\"\",\"play_cnt\":\"0\",\"pre_total_fee\":\"8.95\",\"prepared_lat\":\"0.000000\",\"prepared_lng\":\"0.000000\",\"prepared_time\":\"0000-00-00 00:00:00\",\"product_id\":\"21042\",\"promise_time\":\"0\",\"promise_type\":\"0\",\"railway_type\":\"0\",\"reassign_last_order_id\":\"0\",\"reassign_order_source\":\"0\",\"reduce_carbon\":\"0\",\"region\":\"0\",\"region_type\":\"0\",\"remark\":\"\",\"remark_info\":\"{\\\"delivery_receiver_info\\\":{\\\"name\\\":\\\"\\\",\\\"phone\\\":\\\"\\\",\\\"verify_code\\\":\\\"\\\",\\\"sender_type\\\":\\\"\\\",\\\"obj_type\\\":\\\"\\\",\\\"to_driver_msg\\\":\\\"\\\"}}\",\"require_level\":\"21042\",\"resend_reason\":\"\",\"roaming\":\"0\",\"route_type\":\"0\",\"safety_info\":\"{\\\"remind_type\\\":0}\",\"scan_code_type\":\"0\",\"scene_ids\":\"\",\"schema_id\":\"1\",\"serial_order\":\"0\",\"setoncar_time\":\"0000-00-00 00:00:00\",\"source_car_level\":\"0\",\"source_product_id\":\"0\",\"source_type\":\"1\",\"split_fare_info\":\"\",\"split_fare_version\":\"0\",\"start_broadcast_time\":\"0\",\"start_broadcast_time_type\":\"0\",\"start_commercial_area\":\"\",\"start_dest_distance\":\"3989\",\"starting_lat\":\"-37.713920\",\"starting_lng\":\"144.888620\",\"starting_name\":\"7 Dromana Ave, Airport West VIC 3042, Australia\",\"starting_poi_id\":\"ChIJDyy2delb1moR-NPQ4Y14b9c\",\"starting_tag\":\"0\",\"station_service_control\":\"0\",\"strategy_token\":\"457a5002caedf67059d31c38cb5941f1:bdf32bd0802cdd49178d6c4053fbf893\",\"strive_car_level\":\"21042\",\"strive_notify_status\":\"0\",\"strive_time\":\"2021-01-13 07:45:16\",\"tags\":\"\",\"tip\":\"0\",\"to_address\":\"13 Centreway, Keilor East VIC 3033, Australia\",\"to_area\":\"0\",\"to_county\":\"0\",\"to_name\":\"13 Centreway\",\"travel_id\":\"0\",\"tripcloud_app_id\":\"0\",\"tripcloud_extra_info\":\"\",\"tripcloud_open_oid\":\"\",\"tripcloud_open_pid\":\"\",\"type\":\"0\",\"upgrade_scene\":\"0\",\"upper_limit_price\":\"0\",\"upper_limit_price_discount\":\"0\",\"upper_limit_price_type\":\"0\",\"vendor_trade_id\":\"\",\"verify_level\":\"-1\",\"version\":\"3\",\"virtual_phone\":\"1\",\"walk_type\":\"0\",\"way_points_a_info\":\"\",\"way_points_a_status\":\"0\",\"way_points_b_info\":\"\",\"way_points_b_status\":\"0\",\"way_points_version\":\"\",\"weixin_chn\":\"0\",\"with_flight_number\":\"0\",\"x_activity_type\":\"0\"},{\"_birth_time\":\"2021-01-12 20:41:57\",\"_create_time\":\"2021-01-12 20:41:56\",\"_modify_time\":\"2021-01-12 21:03:21\",\"_modify_time_ns\":\"0\",\"_status\":\"1\",\"actual_level\":\"0\",\"additional_cap_price\":\"0\",\"additional_charge\":\"0\",\"additional_estimate_fixed_fees\":\"\",\"additional_estimate_id\":\"0\",\"additional_pre_total_fee\":\"0\",\"airport_type\":\"0\",\"approach_airport\":\"0\",\"approach_railway\":\"0\",\"area\":\"61020600\",\"arrive_time\":\"2021-01-12 20:48:56\",\"assign_company_type\":\"0\",\"assign_type\":\"1\",\"assigned_lat\":\"-37.817054\",\"assigned_lng\":\"144.960834\",\"assigned_time\":\"2021-01-12 20:42:02\",\"balance_chn\":\"0\",\"begin_charge_lat\":\"-37.818594\",\"begin_charge_lng\":\"144.963841\",\"begin_charge_time\":\"2021-01-12 20:49:03\",\"begun_lat\":\"-37.818594\",\"begun_lng\":\"144.963841\",\"begun_time\":\"2021-01-12 20:49:03\",\"bigc_info\":\"\",\"biz_ticket\":\"\",\"blind_type\":\"0\",\"booking_assign\":\"0\",\"bouns\":\"0\",\"business_id\":\"383\",\"call_car\":\"0\",\"call_times\":\"1\",\"callcar_name\":\"\",\"cancelled_lat\":\"0.000000\",\"cancelled_lng\":\"0.000000\",\"cancelled_time\":\"0000-00-00 00:00:00\",\"cap_chn\":\"0\",\"cap_price\":\"19.50\",\"capacity_level\":\"21042\",\"car_id\":\"360287970195384211\",\"car_ticket\":\"0\",\"card_type\":\"\",\"carpool_contract_driver\":\"0\",\"carpool_long_order\":\"0\",\"carpool_order_scene\":\"-1\",\"carpool_price_type\":\"0\",\"carpool_type\":\"0\",\"channel\":\"0\",\"chengyidan_type\":\"0\",\"close_reason\":\"0\",\"combo_distance\":\"0.00\",\"combo_fee\":\"0.00\",\"combo_id\":\"0\",\"combo_time\":\"0\",\"combo_type\":\"0\",\"commercial_type\":\"0\",\"company_group_ids\":\"\",\"complete_type\":\"0\",\"completed_lat\":\"0.000000\",\"completed_lng\":\"0.000000\",\"completed_time\":\"2021-01-12 21:03:21\",\"compress_type\":\"0\",\"consult_min\":\"15\",\"consult_status\":\"1\",\"consult_time\":\"2021-01-12 20:57:02\",\"contract_type\":\"0\",\"cooperation_id\":\"0\",\"coordinate_type\":\"2\",\"count_price_type\":\"2\",\"country_iso_code\":\"AU\",\"county\":\"61020604\",\"coupon_chn\":\"0\",\"coupon_info\":\"{\\\"used_coupon_id\\\":\\\"\\\",\\\"used_coupon_discount\\\":\\\"\\\"}\",\"current_lat\":\"-37.818565\",\"current_lng\":\"144.963871\",\"custom_service\":\"0\",\"d_sub_id\":\"0\",\"delay_time_start\":\"0000-00-00 00:00:00\",\"departure_recommend\":\"0\",\"departure_time\":\"2021-01-12 20:41:56\",\"dest_commercial_area\":\"\",\"dest_lat\":\"-37.835023\",\"dest_lng\":\"144.861560\",\"dest_name\":\"5/6 Cleghorn Avenue, Altona North VIC, Australia\",\"dest_poi_id\":\"EjA1LzYgQ2xlZ2hvcm4gQXZlbnVlLCBBbHRvbmEgTm9ydGggVklDLCBBdXN0cmFsaWEiNxo1CjASLgoUChIJf6EX6Cdh1moR0f3363RWBBMQBioUChIJ8dAF7Sdh1moR\",\"dest_tag\":\"0\",\"destination_fixed\":\"1\",\"disability_type\":\"0\",\"discount_chn\":\"0\",\"dispatch_driver_type\":\"0\",\"distance\":\"13.0\",\"district\":\"02522\",\"driver_display_price\":\"0.00\",\"driver_dynamic_times\":\"0\",\"driver_estimate_price\":\"0\",\"driver_id\":\"650910926653871\",\"driver_phone\":\"434867041\",\"driver_product_id\":\"32\",\"driver_snapshot\":\"\",\"driver_start_distance\":\"1617\",\"driver_stock_out_time\":\"\",\"driver_type\":\"1\",\"dual_nocarpool_estimate_id\":\"\",\"duse_march_mode\":\"0\",\"dynamic_price\":\"0\",\"emergency_service_type\":\"0\",\"end_charge_lat\":\"-37.835062\",\"end_charge_lng\":\"144.861330\",\"enterprise_flag\":\"0\",\"estimate_fixed_fees\":\"[{\\\"name\\\":\\\"levy_fee\\\",\\\"value\\\":1.1,\\\"quantity_unit\\\":\\\"\\\"},{\\\"name\\\":\\\"commission_fee\\\",\\\"value\\\":0.55,\\\"quantity_unit\\\":\\\"\\\"},{\\\"name\\\":\\\"highway_fee\\\",\\\"value\\\":0,\\\"quantity_unit\\\":\\\"\\\"},{\\\"name\\\":\\\"taxes_fee\\\",\\\"value\\\":0,\\\"quantity_unit\\\":\\\"\\\"}]\",\"estimate_id\":\"2c5ce2253b6e5a244864139ea61f1768\",\"estimate_time\":\"16\",\"ext_driver_id\":\"\",\"ext_order_id\":\"\",\"ext_sub_product_id\":\"0\",\"extend_feature\":\"{\\\"estimate_info\\\":{\\\"estimate_fixed_fees\\\":\\\"[{\\\\\\\"name\\\\\\\":\\\\\\\"levy_fee\\\\\\\",\\\\\\\"value\\\\\\\":1.1,\\\\\\\"quantity_unit\\\\\\\":\\\\\\\"\\\\\\\"},{\\\\\\\"name\\\\\\\":\\\\\\\"commission_fee\\\\\\\",\\\\\\\"value\\\\\\\":0.55,\\\\\\\"quantity_unit\\\\\\\":\\\\\\\"\\\\\\\"},{\\\\\\\"name\\\\\\\":\\\\\\\"highway_fee\\\\\\\",\\\\\\\"value\\\\\\\":0,\\\\\\\"quantity_unit\\\\\\\":\\\\\\\"\\\\\\\"},{\\\\\\\"name\\\\\\\":\\\\\\\"taxes_fee\\\\\\\",\\\\\\\"value\\\\\\\":0,\\\\\\\"quantity_unit\\\\\\\":\\\\\\\"\\\\\\\"}]\\\",\\\"fixed_preferential\\\":0,\\\"red_packet\\\":-1},\\\"neworder_info\\\":{\\\"is_region\\\":0,\\\"platform_type\\\":2}}\",\"extra_info\":\"{\\\"card_index\\\":\\\"80427\\\",\\\"user_ip\\\":\\\"49.179.183.194\\\"}\",\"extra_type\":\"4244036\",\"finish_time\":\"2021-01-12 21:03:18\",\"finished_lat\":\"-37.835062\",\"finished_lng\":\"144.861330\",\"finished_time\":\"2021-01-12 21:03:18\",\"fixed_price_type\":\"0\",\"free_chn\":\"0\",\"freeze_source\":\"0\",\"freeze_status\":\"0\",\"from_address\":\"340 State Route 30, Melbourne VIC 3000, Australia\",\"from_name\":\"340, State Route 30\",\"geofencing\":\"0\",\"global_order_id\":\"\",\"gulfstream_ahead_assigned\":\"\",\"gulfstream_guide_scene\":\"\",\"gulfstream_last_order_id\":\"\",\"haolidan_type\":\"0\",\"hotel_type\":\"0\",\"input\":\"1\",\"international_signpost\":\"{\\\"airportRide\\\":0,\\\"functions\\\":{\\\"price_mode\\\":0}}\",\"invitation_type\":\"0\",\"is_accurate_order\":\"0\",\"is_anycar\":\"0\",\"is_cancel_comment\":\"1\",\"is_carpool_success\":\"0\",\"is_down_accept\":\"0\",\"is_dual_carpool_price\":\"0\",\"is_female_travel\":\"0\",\"is_pay\":\"1\",\"is_platform_paid\":\"0\",\"is_rainbow\":\"0\",\"is_semi_assign\":\"0\",\"is_short_book\":\"0\",\"is_social_security_driver\":\"0\",\"is_special_price\":\"0\",\"is_special_rate\":\"0\",\"is_split_fare\":\"0\",\"level\":\"5\",\"level_type\":\"0\",\"line_up\":\"0\",\"local_currency\":\"AUD\",\"local_time_zone\":\"660\",\"long_rent_type\":\"0\",\"loss_remand\":\"0\",\"menu_id\":\"\",\"mixed_payment_info\":\"\",\"new_lat\":\"-37.818565\",\"new_lng\":\"144.963871\",\"new_time\":\"2021-01-12 20:41:57\",\"offline_pay_status\":\"0\",\"order_id\":\"87973519087668\",\"order_status\":\"5\",\"original_passenger_count\":\"0\",\"p_sub_id\":\"0\",\"pangu_max\":\"0.00\",\"pangu_times\":\"0.00\",\"partner_id\":\"0\",\"passenger_count\":\"0\",\"passenger_id\":\"87960949791571\",\"passenger_phone\":\"+61451197416\",\"pay_type\":\"256\",\"pbd_ext_oid\":\"\",\"pbd_oid\":\"\",\"play_cnt\":\"0\",\"pre_total_fee\":\"19.50\",\"prepared_lat\":\"-37.818598\",\"prepared_lng\":\"144.963831\",\"prepared_time\":\"2021-01-12 20:48:56\",\"product_id\":\"32\",\"promise_time\":\"0\",\"promise_type\":\"0\",\"railway_type\":\"0\",\"reassign_last_order_id\":\"0\",\"reassign_order_source\":\"0\",\"reduce_carbon\":\"0\",\"region\":\"0\",\"region_type\":\"0\",\"remark\":\"\",\"remark_info\":\"{\\\"delivery_receiver_info\\\":{\\\"name\\\":\\\"\\\",\\\"phone\\\":\\\"\\\",\\\"verify_code\\\":\\\"\\\",\\\"sender_type\\\":\\\"\\\",\\\"obj_type\\\":\\\"\\\",\\\"to_driver_msg\\\":\\\"\\\"}}\",\"require_level\":\"3100\",\"resend_reason\":\"\",\"roaming\":\"0\",\"route_type\":\"0\",\"safety_info\":\"{\\\"remind_type\\\":0}\",\"scan_code_type\":\"0\",\"scene_ids\":\"\",\"schema_id\":\"1\",\"serial_order\":\"0\",\"setoncar_time\":\"0000-00-00 00:00:00\",\"source_car_level\":\"0\",\"source_product_id\":\"0\",\"source_type\":\"1\",\"split_fare_info\":\"\",\"split_fare_version\":\"0\",\"start_broadcast_time\":\"0\",\"start_broadcast_time_type\":\"0\",\"start_commercial_area\":\"\",\"start_dest_distance\":\"12975\",\"starting_lat\":\"-37.818640\",\"starting_lng\":\"144.963600\",\"starting_name\":\"340 State Route 30, Melbourne VIC 3000, Australia\",\"starting_poi_id\":\"ChIJUVpZDbNC1moR-hyUix_j6K0\",\"starting_tag\":\"0\",\"station_service_control\":\"0\",\"strategy_token\":\"c57eef4e6974824666c8bc9763e4aaf2:febcab74d96212de75b65eaeaad52a32\",\"strive_car_level\":\"3100\",\"strive_notify_status\":\"0\",\"strive_time\":\"2021-01-12 20:42:02\",\"tags\":\"\",\"tip\":\"0\",\"to_address\":\"Altona North VIC, Australia\",\"to_area\":\"0\",\"to_county\":\"0\",\"to_name\":\"5/6 Cleghorn Avenue\",\"travel_id\":\"0\",\"tripcloud_app_id\":\"0\",\"tripcloud_extra_info\":\"\",\"tripcloud_open_oid\":\"\",\"tripcloud_open_pid\":\"\",\"type\":\"0\",\"upgrade_scene\":\"0\",\"upper_limit_price\":\"0\",\"upper_limit_price_discount\":\"0\",\"upper_limit_price_type\":\"0\",\"vendor_trade_id\":\"\",\"verify_level\":\"-1\",\"version\":\"3\",\"virtual_phone\":\"1\",\"walk_type\":\"0\",\"way_points_a_info\":\"\",\"way_points_a_status\":\"0\",\"way_points_b_info\":\"\",\"way_points_b_status\":\"0\",\"way_points_version\":\"\",\"weixin_chn\":\"0\",\"with_flight_number\":\"0\",\"x_activity_type\":\"0\"}]";

    }
}
