package leetcode.One.Thousand.sortString;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-25 17:37
 * @desc 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
 *
 * 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
 * 重复步骤 2 ，直到你没法从 s 中选择字符。
 * 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
 * 重复步骤 5 ，直到你没法从 s 中选择字符。
 * 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
 *
 * 请你返回将 s 中字符重新排序后的 结果字符串 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "aaaabbbbcccc"
 * 输出："abccbaabccba"
 * 解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
 * 第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
 * 第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
 * 第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
 * 第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"
 * 示例 2：
 *
 * 输入：s = "rat"
 * 输出："art"
 * 解释：单词 "rat" 在上述算法重排序以后变成 "art"
 * 示例 3：
 *
 * 输入：s = "leetcode"
 * 输出："cdelotee"
 * 示例 4：
 *
 * 输入：s = "ggggggg"
 * 输出："ggggggg"
 * 示例 5：
 *
 * 输入：s = "spo"
 * 输出："ops"
 *
 * 链接：https://leetcode-cn.com/problems/increasing-decreasing-string
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class sortString {

    private static StringBuilder result;
    private static StringBuilder temp;

    public static String sortString(String s) {
        if(s.length() <= 1){
            return s;
        }
        temp = new StringBuilder(s);
        result = new StringBuilder();
        while (result.length() < s.length()){
            small2Big(temp);
            big2Small(temp);

        }
        return result.toString();
    }

    public static void small2Big(StringBuilder temp){
        char smallest = 0;// 最小的值
        char small;
        while (true){
            // 选取次小值
            small = 'z' + 1;
            boolean isBiggest = true;
            for (int i = 0; i < temp.length(); i++){
                if(temp.charAt(i) <= smallest){
                    continue;
                }
                if(temp.charAt(i) < small){
                    isBiggest = false;
                    small = temp.charAt(i);
                }
            }
            // 添加该元素
            if(!isBiggest){
                result.append(small);
                // 移除该元素
                removeChar(small);
            } else {
                // 找不到更小的值
                break;
            }
            // 更新最小的值
            smallest = small;
        }
    }

    public static void big2Small(StringBuilder temp){
        char biggest = 'z' + 1;// 最小的值
        char big;
        while (true){
            // 选取次大值
            big = 0;
            boolean isSmaller = true;
            for (int i = 0; i < temp.length(); i++){
                if(temp.charAt(i) >= biggest){
                    continue;
                }
                if(temp.charAt(i) > big){
                    isSmaller = false;
                    big = temp.charAt(i);
                }
            }
            // 添加该元素
            if(!isSmaller){
                result.append(big);
                // 移除该元素
                removeChar(big);
            } else {
                // 找不到更小的值
                break;
            }
            // 更新最小的值
            biggest = big;
        }
    }

    public static void removeChar(char c){
        for(int i = 0; i < temp.length();i++){
            if(temp.charAt(i) == c){
                temp.deleteCharAt(i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(sortString("jcdlgiszuuzsigldcj"));
        System.out.println(sortString("aaaabbbbcccc"));
        System.out.println(sortString("leetcode"));
        System.out.println(sortString("rat"));
        System.out.println(sortString("ggggggg"));
        System.out.println(sortString("spo"));
    }
}
