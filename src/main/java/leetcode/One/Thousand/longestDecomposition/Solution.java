package leetcode.One.Thousand.longestDecomposition;
//你会得到一个字符串 text 。你应该把它分成 k 个子字符串 (subtext1, subtext2，…， subtextk) ，要求满足:
//
//
// subtexti 是 非空 字符串
// 所有子字符串的连接等于 text ( 即subtext1 + subtext2 + ... + subtextk == text )
// 对于所有 i 的有效值( 即 1 <= i <= k ) ，subtexti == subtextk - i + 1 均成立
//
//
// 返回k可能最大值。
//
//
//
// 示例 1：
//
//
//输入：text = "ghiabcdefhelloadamhelloabcdefghi"
//输出：7
//解释：我们可以把字符串拆分成 "(ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)"。
//
//
// 示例 2：
//
//
//输入：text = "merchant"
//输出：1
//解释：我们可以把字符串拆分成 "(merchant)"。
//
//
// 示例 3：
//
//
//输入：text = "antaprezatepzapreanta"
//输出：11
//解释：我们可以把字符串拆分成 "(a)(nt)(a)(pre)(za)(tpe)(za)(pre)(a)(nt)(a)"。
//
//
//
//
// 提示：
//
//
// 1 <= text.length <= 1000
// text 仅由小写英文字符组成
//
// Related Topics 贪心 双指针 字符串 动态规划 哈希函数 滚动哈希 👍 108 👎 0
/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2023/4/12 4:34 PM
 * @Version: 1.initial version; 2023/4/12 4:34 PM
 */
public class Solution {
    public int longestDecomposition(String text) {
        int n = text.length();
        int res = 0;
        int l = 0, r = n - 1;
        while (l <= r) {
            int len = 1;
            while (l + len - 1 < r - len + 1) {
                if (judge(text, l, r - len + 1, len)) {
                    res += 2;
                    break;
                }
                ++len;
            }
            if (l + len - 1 >= r - len + 1) {
                ++res;
            }
            l += len;
            r -= len;
        }
        return res;
    }

    public boolean judge(String text, int l1, int l2, int len) {
        while (len > 0) {
            if (text.charAt(l1) != text.charAt(l2)) {
                return false;
            }
            ++l1;
            ++l2;
            --len;
        }
        return true;
    }
}
