package leetcode.History.FrogJump;

/*
 * @author:liuzhaolu
 * @createTime: 2019-09-27 17:51
 * @desc:一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Solution2 {
    public int JumpFloorII(int target) {
        if(target == 1){
            return 1;
        }
        int sum = 0;
        for(int i = 1; i < target; i++){
            sum += JumpFloorII(target - i);
        }
        return sum + 1;
    }

    public static void main(String[] args){
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.JumpFloorII(3));
    }
}
