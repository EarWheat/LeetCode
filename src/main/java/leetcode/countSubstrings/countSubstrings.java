package leetcode.countSubstrings;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-19 16:57
 * @desc:
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。

 

示例 1：

输入："abc"
输出：3
解释：三个回文子串: "a", "b", "c"
示例 2：

输入："aaa"
输出：6
解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
a 1
aa 3
aaa 6
aaaa
a a a a aa aa aa aaa aaa aaaa
* dp[0] = 0
* dp[1] = 1    //a
* dp[2] = dp[1] + 1 + "aa"   // 1是本身
* dp[3] = dp[2] + 1 + "aaa"
 */
public class countSubstrings {
    /**
     * 动态规划
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        for(int i = 1; i <= s.length();i++){
            dp[i] = dp[i-1] + numOfSubString(s.substring(0,i));
        }
        return dp[s.length()];
    }

    // 暴力求解
    public static int answer(String s){
        // 从中间向两边拓展
        int res = 0;
        int n = s.length();

        // dp[i][j] 表示[i,j]的字符是否为回文子串
        boolean[][] dp = new boolean[n][n];

        // 注意，外层循环要倒着写，内层循环要正着写
        // 因为要求dp[i][j] 需要知道dp[i+1][j-1]
        for(int i=n-1; i>=0; i--){
            for(int j=i; j<n; j++){

                // (s.charAt(i)==s.charAt(j) 时，当元素个数为1,2,3个时，一定为回文子串
                if(s.charAt(i)==s.charAt(j) && (j-i<=2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    res++;
                }
            }
        }

        return res;
    }

    private static Integer numOfSubString(String s){
        int result = 0;
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == s.charAt(s.length() -1)){
                if(isPalindromeStr(s.substring(i))){
                    result++;
                }
            }
        }
        return result;
    }

    // 判断是否是回文字符串
    public static boolean isPalindromeStr(String s){
        if(s.length() <= 1){
            return true;
        }
        if(s.length() == 2){
            return s.charAt(0) == s.charAt(1);
        }
        if(s.charAt(0) == s.charAt(s.length()-1)){
            return isPalindromeStr(s.substring(1,s.length() - 1));
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aa"));
        System.out.println(countSubstrings("aaa"));
        System.out.println(countSubstrings(""));
        System.out.println(countSubstrings("aaaa"));
    }
}
