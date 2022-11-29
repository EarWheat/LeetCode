package leetcode.One.Thousand.minOperationsStr;
//给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。
//
// 交替字符串 定义为：如果字符串中不存在相邻两个字符相等的情况，那么该字符串就是交替字符串。例如，字符串 "010" 是交替字符串，而字符串 "0100"
//不是。
//
// 返回使 s 变成 交替字符串 所需的 最少 操作数。
//
//
//
// 示例 1：
//
// 输入：s = "0100"
//输出：1
//解释：如果将最后一个字符变为 '1' ，s 就变成 "0101" ，即符合交替字符串定义。
//
//
// 示例 2：
//
// 输入：s = "10"
//输出：0
//解释：s 已经是交替字符串。
//
//
// 示例 3：
//
// 输入：s = "1111"
//输出：2
//解释：需要 2 步操作得到 "0101" 或 "1010" 。
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁴
// s[i] 是 '0' 或 '1'
//
// Related Topics 字符串 👍 77 👎 0
/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/6/23 5:58 PM
 * @Version: 1.initial version; 2022/6/23 5:58 PM
 */
public class Solution {
    public int minOperations(String s) {
        return Math.min(startWith0(s), startWith1(s));
    }

    public int startWith0(String s){
        int result = 0;
        if(s.charAt(0) != '0'){
            result++;
        }
        char temp = '0';
        int i = 1;
        while (i < s.length()){
            if(s.charAt(i) == temp){
                temp = temp == '0' ? '1' : '0';
                result++;
            } else {
                temp = s.charAt(i);
            }
            i++;
        }
        return result;
    }

    public int startWith1(String s){
        int result = 0;
        if(s.charAt(0) != '1'){
            result++;
        }
        char temp = '1';
        int i = 1;
        while (i < s.length()){
            if(s.charAt(i) == temp){
                temp = temp == '0' ? '1' : '0';
                result++;
            } else {
                temp = s.charAt(i);
            }
            i++;
        }
        return result;
    }
}
