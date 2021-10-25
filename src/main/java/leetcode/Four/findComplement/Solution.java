package leetcode.Four.findComplement;


/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/10/18 2:05 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int findComplement(int num) {
        String n = Integer.toBinaryString(num);
        int result = 0;
        for (int i = 0; i < n.length(); i++) {
            if(n.charAt(i) == '0'){
                result += Math.pow(2,n.length() - 1 - i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findComplement(5));
        System.out.println(solution.findComplement(14));
        System.out.println(solution.findComplement(1));
    }
}
