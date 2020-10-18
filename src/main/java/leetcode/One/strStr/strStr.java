package leetcode.One.strStr;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-10-18 08:22
 * @desc
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class strStr {
    public static int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        int index = 0;
        int matchLength = 0;    // 匹配的长度
        while (index < haystack.length()){
            if(haystack.charAt(index) == needle.charAt(matchLength)){
                matchLength++;
                if(matchLength >= needle.length()){
                    index++;    // 保证index用于是++
                    break;
                }
            } else {
                // index需要回退
                index = index - matchLength;
                matchLength = 0;
            }
            index++;
        }
        // 刚好只匹配了最后一个
        if(index >= haystack.length() && matchLength < needle.length()){
            return -1;
        }
        return index - matchLength;
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi","issip"));
        System.out.println(strStr("aaaa","bba"));
        System.out.println(strStr("hello","o"));
        System.out.println(strStr("hello","oh"));
    }
}
