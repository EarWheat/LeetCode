package leetcode.One.Thousand.longestDiverseString;

/**
 * @author ：liuzhaolu
 * @description：1405. 最长快乐字符串
 * @prd : https://leetcode-cn.com/problems/longest-happy-string/
 * @date ：2022/2/7 4:49 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/2/7 4:49 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder stringBuilder = new StringBuilder();
        while (a > 0 || b > 0 || c > 0){
            if(stringBuilder.toString().endsWith("aa")){
                if(b >= c && b > 0){
                    stringBuilder.append('b');
                    b--;
                } else if(c > 0){
                    stringBuilder.append('c');
                    c--;
                } else {
                    return stringBuilder.toString();
                }
            } else if(stringBuilder.toString().endsWith("bb")){
                if(a >= c && a > 0){
                    stringBuilder.append('a');
                    a--;
                } else if(c > 0){
                    stringBuilder.append('c');
                    c--;
                } else {
                    return stringBuilder.toString();
                }
            } else if(stringBuilder.toString().endsWith("cc")){
                if(a >= b && a > 0){
                    stringBuilder.append('a');
                    a--;
                } else if(b > 0){
                    stringBuilder.append('b');
                    b--;
                } else {
                    return stringBuilder.toString();
                }
            } else {
                if(a >= b && a >= c){
                    stringBuilder.append('a');
                    a--;
                } else if(b > a && b >= c){
                    stringBuilder.append('b');
                    b--;
                } else if(c > a && c > b){
                    stringBuilder.append('c');
                    c--;
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestDiverseString(1,1,7));
    }
}
