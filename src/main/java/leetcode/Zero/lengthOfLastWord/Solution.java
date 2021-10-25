package leetcode.Zero.lengthOfLastWord;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/21 11:06 上午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.trim().split(" ");
        return words[words.length - 1].length();
    }
}
