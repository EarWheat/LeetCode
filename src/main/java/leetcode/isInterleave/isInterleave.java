package leetcode.isInterleave;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-18 21:21
 * @desc:
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。

示例 1:

输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
输出: true
示例 2:

输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
输出: false

* 思路：
* 减法：s3减去s1之后等于s2就成功。
 */
public class isInterleave {
    public static boolean isInterleave(String s1, String s2, String s3) {
        StringBuilder stringBuilder = new StringBuilder(s3);
        int j = 0;
        int index = 0;
        for(int i = 0; i < s3.length(); i++){
            if(s3.charAt(i) == s1.charAt(j)){
                stringBuilder.deleteCharAt(index);
                j++;
            } else {
                index++;
            }
        }
        // s1都未匹配完
        if(j < s1.length()){
            return false;
        }
        return stringBuilder.toString().equals(s2);
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc","dbbca","aadbbcbcac"));
    }
}
