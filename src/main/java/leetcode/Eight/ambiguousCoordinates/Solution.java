package leetcode.Eight.ambiguousCoordinates;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/11/7 3:34 PM
 * @Version: 1.initial version; 2022/11/7 3:34 PM
 */
public class Solution {
    public List<String> ambiguousCoordinates(String s) {
        s = s.substring(1, s.length() - 1);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            List<String> leftList = insertDian(left);
            List<String> rightList = insertDian(right);
            result.addAll(mergeList(leftList, rightList));
        }
        return result;
    }

    public List<String> mergeList(List<String> left, List<String> right) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < left.size(); i++) {
            for (int j = 0; j < right.size(); j++) {
                StringBuilder temp = new StringBuilder();
                temp.append("(").append(left.get(i)).append(",").append(right.get(j)).append(")");
                result.add(temp.toString());
            }
        }
        return result;
    }

    public List<String> insertDian(String s) {
        List<String> result = new ArrayList<>();
        if(s.length() == 1 && "0".equals(s)){
            result.add(s);
            return result;
        }
        for (int i = 0; i < s.length(); i++) {
            StringBuilder temp = new StringBuilder();
            temp.append(s, 0, i).append(".").append(s.substring(i));
            if (isValid(temp.toString())) {
                if (temp.toString().startsWith(".")) {
                    temp.deleteCharAt(0);
                }
                result.add(temp.toString());
            }
        }
        return result;
    }

    public Boolean isValid(String s) {
        if ("0".equals(s)) {
            return true;
        }
        String[] split = s.split("\\.");
        String left = split[0];
        String right = split[1];
        // 左右为空
        if (left.length() == 0 || right.length() == 0) {
            return !right.startsWith("0");
        }
        // 0x不行
        if (left.length() > 1 && left.startsWith("0")) {
            return false;
        }
        // "xx.x0"不行
        if (right.endsWith("0")) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
//        String s = "(123)";
//        System.out.println(s.substring(1, s.length() - 1));
        System.out.println(solution.ambiguousCoordinates("(0123)"));
    }
}
