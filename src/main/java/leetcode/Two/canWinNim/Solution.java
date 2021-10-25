package leetcode.Two.canWinNim;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/18 2:19 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public boolean canWinNim(int n) {
        if(n <= 3){
            return true;
        }
        //4 false 8 false 12 false
        return n % 4 != 0;
    }
}
