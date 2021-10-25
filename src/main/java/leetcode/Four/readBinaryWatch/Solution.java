package leetcode.Four.readBinaryWatch;


import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/6/21 上午10:47
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= turnedOn; i++) {
            List<String> hour = getHour(i, 4);
            List<String> minute = getMinute(turnedOn - i, 6);
            result.addAll(concatTime(hour, minute));
        }

        return result;
    }

    public List<String> concatTime(List<String> hour, List<String> minute){
        List<String> result = new ArrayList<>();
        for(String h : hour){
            for (String m : minute){
                if(Integer.parseInt(m) < 10){
                    m = "0".concat(m);
                }
                String temp = h.concat(":").concat(m);
                result.add(temp);
            }
        }
        return result;
    }

    public List<String> getHour(int turnedOn, int ledNum){
        List<String> result = new ArrayList<>();
        if(turnedOn == 0){
            String temp = "0";
            result.add(temp);
            return result;
        }
        if(turnedOn == 1){
            for(int i = 0; i < ledNum; i++){
                String temp = String.valueOf(1 << i);
                result.add(temp);
            }
            return result;
        }
        for (int i = 0; i <= ledNum - turnedOn; i++) {
            int index = 1 << (ledNum - i - 1);
            List<String> list = getHour(turnedOn - 1, ledNum - i - 1);
            for(String str : list){
                int time = Integer.parseInt(str) + index;
                if(time > 11){
                    continue;
                }
                String temp = String.valueOf(time);
                result.add(temp);
            }
        }
        return result;
    }

    public List<String> getMinute(int turnedOn, int ledNum){
        List<String> result = new ArrayList<>();
        if(turnedOn == 0){
            String temp = "0";
            result.add(temp);
            return result;
        }
        if(turnedOn == 1){
            for(int i = 0; i < ledNum; i++){
                String temp = String.valueOf(1 << i);
                result.add(temp);
            }
            return result;
        }
        for (int i = 0; i <= ledNum - turnedOn; i++) {
            int index = 1 << (ledNum - i - 1);
            List<String> list = getMinute(turnedOn - 1, ledNum - i - 1);
            for(String str : list){
                int time = Integer.parseInt(str) + index;
                if(time > 59){
                    continue;
                }
                String temp = String.valueOf(time);
                result.add(temp);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.readBinaryWatch(2));
    }
}
