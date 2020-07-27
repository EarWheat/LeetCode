package leetcode.isSubsequence;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-27 13:03
 * @desc:
 */
public class isSubsequence {
    public static boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()){
            return false;
        }
        int sIndex = 0;
        int i;
        for(i = 0; i < t.length();i++){
            if(sIndex > s.length() - 1){
                return true;
            }
            if(t.charAt(i) == s.charAt(sIndex)){
                sIndex++;
            }
        }
        if(i == t.length() && sIndex < s.length()){
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
//        System.out.println(isSubsequence("abc","ahbgdc"));
//        System.out.println(isSubsequence("axc","ahbgdc"));
//        System.out.println(isSubsequence("b","c"));

        System.out.println(mergeOrderIds("123,454534,54243","456,123"));


    }

    public static String mergeOrderIds(String s1, String s2){
        if(s1 == null || StringUtils.isBlank(s1)){
            return s2;
        }
        if(s2 == null || StringUtils.isBlank(s2)){
            return s1;
        }
        String[] orderIds1 = s1.split(",");
        String[] orderIds2 = s2.split(",");
        List<String> orderIds = new ArrayList<>();
        for (String ids : orderIds1){
            if(StringUtils.isNotBlank(ids)){
                orderIds.add(ids);
            }
        }
        for (String ids : orderIds2){
            if(StringUtils.isNotBlank(ids)){
                if(!orderIds.contains(ids)){
                    orderIds.add(ids);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < orderIds.size(); i++){
            stringBuilder.append(orderIds.get(i));
            stringBuilder.append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }


}
