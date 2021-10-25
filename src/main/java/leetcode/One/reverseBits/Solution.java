package leetcode.One.reverseBits;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/29 上午7:27
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int reverseBits(int n) {
        int a=0;
        for(int i=0;i<=31;i++){
            a=a+((1&(n>>i))<<(31-i));
        }
        return a;
    }
}
