package leetcode.History.countBinarySubstrings;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-10 17:15
 * @desc:
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。

重复出现的子串要计算它们出现的次数。

示例 1 :

输入: "00110011"
输出: 6
解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。

请注意，一些重复出现的子串要计算它们出现的次数。

另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
示例 2 :

输入: "10101"
输出: 4
解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
注意：

s.length 在1到50,000之间。
s 只包含“0”或“1”字符。

 */
public class countBinarySubstrings {

    /**
     * 新思路：
     * 每个字串必须包含01，所以找到0，1反转的位置，向两边遍历
     * @param s
     * @return
     */
    public static int newCountBinarySubstrings(String s){
        int result = 0, i = 0;
        while (i < s.length() - 1){
            if(s.charAt(i) != s.charAt(i + 1)){
                char a = s.charAt(i);
                char b = s.charAt(i + 1);
                int left = i, right = i + 1;
                while (left >= 0 && right < s.length()){
                    if(s.charAt(left) == a && s.charAt(right) == b){
                        i = right - 1;
                        result++;
                        left--;
                        right++;
                    } else {
                        i = right - 2;
                        break;
                    }
                }
            }
            i++;
        }
        return result;
    }




    public static int countBinarySubstrings(String s) {
        int result = 0;
        for(int i = 0;i < s.length();i++){
            // 起始c
            char temp = s.charAt(i);
            // a表示开始的第一个数字的数量，b表示第二个数字的数量
            int a = 1, b = 0;
            // transform表示反转次数，即1->0或0->1的次数
            int transform = 0;
            int j = i + 1;
            while (transform <= 1 && j < s.length() && a != b){
                if(s.charAt(j) == temp){
                    a++;
                } else {
                    temp = s.charAt(j);
                    b++;
                    transform++;
                    // 交换AB
                    int t = a;
                    a = b;
                    b = t;
                }
                j++;
            }
            if(a == b){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110011"));
        System.out.println(countBinarySubstrings("10101"));

        System.out.println(newCountBinarySubstrings("00110011"));
        System.out.println(newCountBinarySubstrings("10101"));
    }
}
