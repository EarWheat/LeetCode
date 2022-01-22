package leetcode.One.removePalindromeSub;

/**
 * @author ：liuzhaolu
 * @description：1332. 删除回文子序列
 * @prd : https://leetcode-cn.com/problems/remove-palindromic-subsequences/
 * @date ：2022/1/22 2:57 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/22 2:57 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int removePalindromeSub(String s) {
        if(isPalindrome(s)){
            return 1;
        } else {
            return 2;
        }
    }

    public boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;
        while (left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
