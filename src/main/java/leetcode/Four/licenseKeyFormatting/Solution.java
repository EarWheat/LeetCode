package leetcode.Four.licenseKeyFormatting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/10/4 2:00 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public String licenseKeyFormatting(String s, int k) {
        String[] keys = s.trim().split("-");
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = keys.length - 1; i >=0 ; i--)  {
            String key = new StringBuilder(keys[i]).reverse().toString();
            if (temp.length() + key.length() < k) {
                temp.append(key);
            } else if (temp.length() + key.length() == k) {
                stringBuilder.append(temp).append(key).append("-");
                temp = new StringBuilder();
            } else {
                String mergeString = key.substring(0, k - temp.length());
                stringBuilder.append(temp).append(mergeString).append("-");
                temp = new StringBuilder(key.substring(k - temp.length()));
                while (temp.length() >= k){
                    stringBuilder.append(temp.substring(0,k)).append("-");
                    temp = new StringBuilder(temp.substring(k));
                }
            }
        }
        stringBuilder.append(temp);
        stringBuilder.reverse();
        if(stringBuilder.toString().startsWith("-")){
            return stringBuilder.substring(1,stringBuilder.length()).toUpperCase();
        } else {
            return stringBuilder.toString().toUpperCase();
        }
    }

    public static void main(String[] args) {
        String code = "2-4A0r7-4k";
        Solution solution = new Solution();
        System.out.println(solution.licenseKeyFormatting(code,3));
    }
}
