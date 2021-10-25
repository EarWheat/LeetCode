package leetcode.One.Thousand.maximumTime;

import org.apache.commons.lang.StringUtils;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/7/24 6:10 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public String maximumTime(String time) {
        if(!time.contains(":")){
            return null;
        }
        String[] times = time.split(":");
        String hour = times[0];
        String minute = times[1];
        if(hour.contains("?")){
            StringBuilder stringBuilder = new StringBuilder(hour);
            if('?' == stringBuilder.charAt(0)){
                if(stringBuilder.charAt(1) > '3' && stringBuilder.charAt(1) != '?'){
                    stringBuilder.replace(0,1,"1");
                } else {
                    stringBuilder.replace(0,1,"2");
                }
            }
            if('?' == stringBuilder.charAt(1)){
                if(stringBuilder.charAt(0) == '2'){
                    stringBuilder.replace(1,2,"3");
                } else {
                    stringBuilder.replace(1,2,"9");
                }
            }
            hour = stringBuilder.toString();
        }
        if(minute.contains("?")){
            StringBuilder stringBuilder = new StringBuilder(minute);
            if('?' == stringBuilder.charAt(0)){
                stringBuilder.replace(0,1,"5");
            }
            if('?' == stringBuilder.charAt(1)){
                stringBuilder.replace(1,2,"9");
            }
            minute = stringBuilder.toString();
        }
        return hour.concat(":").concat(minute);
    }

    public static void main(String[] args) {
        String time = "?4:03";
        Solution solution = new Solution();
        System.out.println(solution.maximumTime(time));
    }
}
