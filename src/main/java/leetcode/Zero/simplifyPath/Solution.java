package leetcode.Zero.simplifyPath;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author ：liuzhaolu
 * @description：71. 简化路径
 * @prd : https://leetcode-cn.com/problems/simplify-path/
 * @date ：2022/1/6 1:52 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/6 1:52 下午     liuzhaolu       firstVersion
 */
public class Solution {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] file = path.split("/");
        for(String f : file){
            if(!f.equals("/") && !f.equals("") && !f.equals("..") && !f.equals(".")){
                stack.push(f);
            } else if(f.equals("..")){
                if(!stack.empty()){
                    stack.pop();
                }
            }
        }
        StringBuilder result = new StringBuilder("/");
        Stack<String> newStack = new Stack<>();
        while (!stack.empty()){
            newStack.push(stack.pop());
        }
        while (!newStack.empty()){
            result.append(newStack.pop()).append("/");
        }
        if(result.length() > 1 && result.charAt(result.length() - 1) == '/'){
            return result.substring(0, result.length() - 1);
        } else {
            return result.toString();
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.toChineseNum(340001200567L));
    }

    private String[] chineseNum = new String[]{"零","一","二","三","四","五","六","七","八","九"};
    private String[] indexChinese = new String[]{"","十","百","千"};
    private String[] danwei = new String[]{"","万","亿"};



    public String toChineseNum(long n){
        String s = String.valueOf(n);
        int mark = s.length() / 4;
        int start = s.length() % 4;
        StringBuilder result = new StringBuilder();
        int index = 0;
        for (index = 0; index < start; index++) {
            if(index > 0 && s.charAt(index) == '0' && s.charAt(index - 1) == '0'){
                index++;
                continue;
            }
            result.append(chineseNum[Character.getNumericValue(s.charAt(index))]).append(indexChinese[start - 1 - index]);
        }
        if(start > 0){
            result.append(danwei[mark - 1]);
        }
        for (int i = 0; i < mark; i++) {
            for (int j = 0; j < 4; j++) {
                if(s.charAt(index) == '0'){
                    if(j > 0 && s.charAt(index - 1) == '0'){
                        index++;
                        continue;
                    } else {
                        result.append(chineseNum[Character.getNumericValue(s.charAt(index))]);
                    }
                } else {
                    result.append(chineseNum[Character.getNumericValue(s.charAt(index))]).append(indexChinese[3 - j]);
                }
                index++;
            }
            if(result.charAt(result.length() - 1) == '零'){
                result.deleteCharAt(result.length() - 1);
            }
            result.append(danwei[mark - 1 - i]);
        }
        return result.toString();
    }
}
