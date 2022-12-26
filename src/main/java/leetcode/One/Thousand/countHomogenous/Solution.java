package leetcode.One.Thousand.countHomogenous;
//给你一个字符串 s ，返回 s 中 同构子字符串 的数目。由于答案可能很大，只需返回对 10⁹ + 7 取余 后的结果。
//
// 同构字符串 的定义为：如果一个字符串中的所有字符都相同，那么该字符串就是同构字符串。
//
// 子字符串 是字符串中的一个连续字符序列。
//
//
//
// 示例 1：
//
// 输入：s = "abbcccaa"
//输出：13
//解释：同构子字符串如下所列：
//"a"   出现 3 次。
//"aa"  出现 1 次。
//"b"   出现 2 次。
//"bb"  出现 1 次。
//"c"   出现 3 次。
//"cc"  出现 2 次。
//"ccc" 出现 1 次。
//3 + 1 + 2 + 1 + 3 + 2 + 1 = 13
//
// 示例 2：
//
// 输入：s = "xy"
//输出：2
//解释：同构子字符串是 "x" 和 "y" 。
//
// 示例 3：
//
// 输入：s = "zzzzz"
//输出：15
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁵
// s 由小写字符串组成
//
// Related Topics 数学 字符串 👍 44 👎 0

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/12/26 5:03 PM
 * @Version: 1.initial version; 2022/12/26 5:03 PM
 */
public class Solution {
    public int countHomogenous(String s) {
        int left = 0;
        int right = 1;
        int result = 0;
        while (right < s.length()) {
            if (s.charAt(right) != s.charAt(left)) {
                String subString = s.substring(left, right);
                result += getResultString(subString);
                left = right;
            }
            right++;
        }
        String subString = s.substring(left, right);
        result += getResultString(subString);
        return result ;
    }

    public int getResultString(String s) {
        int result = 0;
        int temp = s.length();
        for (int i = 0; i < s.length(); i++) {
            result += temp--;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countHomogenous("abbcccaa"));
    }
}
