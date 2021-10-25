package leetcode.History.repeatedSubstringPattern;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-24 09:49
 * @desc:给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。

示例 1:

输入: "abab"

输出: True

解释: 可由子字符串 "ab" 重复两次构成。
示例 2:

输入: "aba"

输出: False
示例 3:

输入: "abcabcabcabc"

输出: True

解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)

 */
public class repeatedSubstringPattern {
    /**
     * 若存在子串，s第一个字母一定是子串的第一个，s最后一个字母一定是子串最后一个
     * abacabac
     * @param s
     * @return
     */
    public static boolean repeatedSubstringPattern(String s) {
        if(s.length() <= 1){
            return false;
        }
        int middle = s.length() / 2;
        char start = s.charAt(0);
        char end = s.charAt(s.length() - 1);
        int left = 0;
        int right = s.length() - 1;
        // 前后双向遍历一次子串
        while (left <= right){
            if(s.charAt(left) == end && s.charAt(right) == start){
                break;
            }
            left++;
            right--;
        }
        String resultStr = s.substring(0,left + 1);
        // 从中往右遍历一次
        int i = middle - 1;
        int j = middle;
        while (i>=0 && j < s.length()){
            if(s.charAt(i) == s.charAt(j)){
                break;
            }
            i--;
            j++;
        }
        String subStr;
        if(i < 0 || j >= s.length()){
            subStr = s.substring(middle);
        } else {
            subStr = s.substring(middle, j + 1) + s.substring(i + 1, middle);
        }
//        return s.split(resultStr).length == 0 || s.split(subStr).length == 0;
        return s.split(subStr).length == 0;
    }

    public static boolean repeatedSubstringPatternV2(String s) {
        if(s.length() <= 1){
            return false;
        }
        int middle = s.length() / 2;
        for(int i = 0; i < middle; i++){
            if(s.split(s.substring(0,i + 1)).length == 0){
                return true;
            }
        }
        return false;
    }

    /**
     * 假设母串S是由子串s重复N次而成， 则 S+S则有子串s重复2N次， 现在S=Ns， S+S=2Ns 因此S在(S+S)[1:-1]中必出现一次以上
     * @param s
     * @return
     */
    public static boolean answer(String s){
        return (s + s).substring(1, s.length() * 2 - 1).contains(s);
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPatternV2("babbabbabbabbab"));
        System.out.println(repeatedSubstringPatternV2("abaababaab"));
        System.out.println(repeatedSubstringPatternV2("abacabac"));
        System.out.println(repeatedSubstringPatternV2("ababab"));
        System.out.println(repeatedSubstringPatternV2("aba"));
        System.out.println(repeatedSubstringPatternV2("abcabcabcabc"));
    }
}
