package leetcode.Zconvert;

/*
 * @author:liuzhaolu
 * @createTime: 2020-03-04 15:54
 * @desc:将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
* L   C   I   R
* E T O E S I I G
* E   D   H   N
 *之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
* 输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:
* L     D     R
* E   O E   I I
* E C   I H   N
* T     S     G
 */
public class Zconvert {
    public static void main(String[] args){
        String s1 = "LEETCODEISHIRING";
        String s2 = "LEETCODEISHIRING";
        System.out.println(convert(s1,3));
        System.out.println(convert(s2,4));
    }

    public static String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        // Z字中间拐点,行数减去头尾2即可
        int index = numRows - 2;
        // 间隔跳转的数是行数 + 拐点
        int MaxSkip = numRows + index;
        StringBuilder stringBuilder = new StringBuilder();
        // 从头到尾巴
        for(int i = 0; i < numRows;i ++){
            int start = i;
            int skip = MaxSkip - (2 * i);
            while (start < s.length()){
                if(i == 0 || i == numRows - 1){
                    stringBuilder.append(s.charAt(start));
                    start += MaxSkip;
                } else {
                    stringBuilder.append(s.charAt(start));
                    if(start + skip < s.length()){
                        stringBuilder.append(s.charAt(start + skip));
                    }
                    start += MaxSkip;
                }
            }
        }
        return stringBuilder.toString();
    }
}
