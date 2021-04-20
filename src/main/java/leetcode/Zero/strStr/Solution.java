package leetcode.Zero.strStr;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/4/20 下午3:32
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(0)){
                if(isMatch(i,haystack,needle)){
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean isMatch(int index, String haystack, String needle){
        int start = 0;
        for (int i = index; i < haystack.length(); i++) {
            if(start >= needle.length()){
                return true;
            }
            if(haystack.charAt(i) != needle.charAt(start++)){
                return false;
            }
        }
        if(start == needle.length()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String haystack = "a";
        String needle = "a";
        Solution solution = new Solution();
        System.out.println(solution.strStr(haystack,needle));
    }
}
