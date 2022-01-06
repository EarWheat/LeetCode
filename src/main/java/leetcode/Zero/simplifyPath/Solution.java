package leetcode.Zero.simplifyPath;

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
        System.out.println(solution.simplifyPath("/a//b////c/d//././/.."));
    }
}
