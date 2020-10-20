package leetcode.History.isMatch;

/*
 * @author:liuzhaolu
 * @createTime: 2020-05-24 14:13
 * @desc:
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

说明:

s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
示例 2:

输入:
s = "aa"
p = "a*"
输出: true
解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
示例 3:

输入:
s = "ab"
p = ".*"
输出: true
解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
示例 4:

输入:
s = "aab"
p = "c*a*b"
输出: true
解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
示例 5:

输入:
s = "mississippi"
p = "mis*is*p*."
输出: false
 */
public class isMatch {
    public static void main(String[] args) {
        String s = "aaa";
        String p = "a*aaaa";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        int i = 0;  // s指针
        int j = 0;  // p指针
        while (j < p.length()) {
            if(i == s.length()){
                break;
            }
            // s, p 相等
            if(s.charAt(i) == p.charAt(j)){
                i++;
                j++;
            } else {
                if(p.charAt(j) == '*'){
                    // 第0个数字为*
                    if(j == 0){
                        j++;
                        continue;
                    }
                    char lastWord = p.charAt(j - 1);
                    if(lastWord == '.'){
                        i++;
                        continue;
                    }
                    if(s.charAt(i) == lastWord){    // 匹配N个
                        while (s.charAt(i) == lastWord){
                            i++;
                            if(i == s.length()){
                                break;
                            }
                        }
                        if(i == s.length()){
                            break;
                        }
                    } else {    // 上一个字符不想等, 匹配0个
                        j++;
                    }
                } else if(p.charAt(j) == '.'){
                   i++;
                   j++;
                } else {
                    if(p.length() < 2){
                        return false;
                    } else {
                        if(j == p.length() - 1){
                            return false;
                        }
                        if(p.charAt(j+1) == '*'){
                            j = j+2;
                            continue;
                        }
                        return false;
                    }
                }
            }

        }
        // 最后各自遍历
        if(i != s.length()){
            return false;
        }
        if(j < p.length()){
            if(p.charAt(p.length() -1) != '*' && p.charAt(p.length() - 1) != s.charAt(s.length() -1)){
                return false;
            } else {
                return true;
            }
        }
        if(i == s.length() && j == p.length()){
            return true;
        }
        return false;
    }
}
