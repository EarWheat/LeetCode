package leetcode.Four.magicalString;
//神奇字符串 s 仅由 '1' 和 '2' 组成，并需要遵守下面的规则：
//
//
// 神奇字符串 s 的神奇之处在于，串联字符串中 '1' 和 '2' 的连续出现次数可以生成该字符串。
//
//
// s 的前几个元素是 s = "1221121221221121122……" 。如果将 s 中连续的若干 1 和 2 进行分组，可以得到 "1 22 11
//2 1 22 1 22 11 2 11 22 ......" 。每组中 1 或者 2 的出现次数分别是 "1 2 2 1 1 2 1 2 2 1 2 2 ...
//..." 。上面的出现次数正是 s 自身。
//
// 给你一个整数 n ，返回在神奇字符串 s 的前 n 个数字中 1 的数目。
//
//
//
// 示例 1：
//
//
//输入：n = 6
//输出：3
//解释：神奇字符串 s 的前 6 个元素是 “122112”，它包含三个 1，因此返回 3 。
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= n <= 10⁵
//
// Related Topics 双指针 字符串 👍 116 👎 0

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/10/31 12:12 PM
 * @Version: 1.initial version; 2022/10/31 12:12 PM
 */
public class Solution {
    public int magicalString(int n) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < n; i++) {
            temp = buildMagicalString(i, temp, i % 2 == 0 ? '1' : '2');
        }
        return getNumOne(temp.toString(), n);
    }

    public StringBuilder buildMagicalString(int index, StringBuilder string, char c) {
        if (index == 0) {
            return string.append(c);
        }
        if (index == 1) {
            return string.append(c).append(c);
        }
        int num = string.charAt(index) - '0';
        for (int i = 0; i < num; i++) {
            string.append(c);
        }
        return string;
    }

    public int getNumOne(String s, int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.magicalString(6));
    }
}
