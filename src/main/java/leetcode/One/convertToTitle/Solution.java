package leetcode.One.convertToTitle;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/6/29 下午3:45
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    // 26进制
    public String convertToTitle(int columnNumber) {
        if (columnNumber <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber = columnNumber / 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.convertToTitle(28));
        System.out.println(solution.convertToTitle(52));
        System.out.println(solution.convertToTitle(701));
        System.out.println(solution.convertToTitle(2147483647));
    }
}
