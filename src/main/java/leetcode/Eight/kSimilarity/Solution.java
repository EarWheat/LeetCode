package leetcode.Eight.kSimilarity;
//对于某些非负整数 k ，如果交换 s1 中两个字母的位置恰好 k 次，能够使结果字符串等于 s2 ，则认为字符串 s1 和 s2 的 相似度为 k 。
//
// 给你两个字母异位词 s1 和 s2 ，返回 s1 和 s2 的相似度 k 的最小值。
//
//
//
// 示例 1：
//
//
//输入：s1 = "ab", s2 = "ba"
//输出：1
//
//
// 示例 2：
//
//
//输入：s1 = "abc", s2 = "bca"
//输出：2
//
//
//
//
// 提示：
//
//
// 1 <= s1.length <= 20
// s2.length == s1.length
// s1 和 s2 只包含集合 {'a', 'b', 'c', 'd', 'e', 'f'} 中的小写字母
// s2 是 s1 的一个字母异位词
//
// Related Topics 广度优先搜索 字符串 👍 215 👎 0

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/9/21 5:37 PM
 * @Version: 1.initial version; 2022/9/21 5:37 PM
 */
public class Solution {
    public int kSimilarity(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int step = 0;
        for (int i = 0; i < s1.length(); i++) {
            char origin = chars1[i];
            char target = chars2[i];
            if(origin == target){
                continue;
            }
            for (int j = i + 1; j < s1.length(); j++) {
                if (chars1[j] == target && chars2[j] == origin) {
                    swap(chars1, i, j);
                    step++;
                    break;
                }
            }
        }
        int diff = 0;
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                diff++;
            }
        }
        if(diff == 0){
            return step;
        } else if(diff % 2 == 0){
            return step + diff - 2;
        } else {
            return step + diff - 1;
        }
    }

    public void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kSimilarity("aabbccddee", "dcacbedbae"));
    }

}
