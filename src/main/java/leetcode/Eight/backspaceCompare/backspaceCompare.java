package leetcode.Eight.backspaceCompare;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-10-19 10:02
 * @desc 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 *
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 *
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 *
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *  
 *
 * 提示：
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 *
 * 链接：https://leetcode-cn.com/problems/backspace-string-compare
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class backspaceCompare {
    public static boolean backspaceCompare(String S, String T) {
        if(S.equals(T)){
            return true;
        }
        Stack stack = new Stack();
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) != '#'){
                stack.push(S.charAt(i));
            } else {
                if(stack.size() > 0){
                    stack.pop();
                }
            }
        }
        S = stack2String(stack);
        for(int i = 0; i < T.length(); i++){
            if(T.charAt(i) != '#'){
                stack.push(T.charAt(i));
            } else {
                if(stack.size() > 0){
                    stack.pop();
                }
            }
        }
        T = stack2String(stack);
        return S.equals(T);
    }

    public static String stack2String(Stack stack){
        StringBuilder stringBuilder = new StringBuilder();
        while (stack.size() != 0){
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
//        System.out.println(backspaceCompare("ab##","c#d#"));
        System.out.println(backspaceCompare("#####abc","abb#c"));

    }
}
