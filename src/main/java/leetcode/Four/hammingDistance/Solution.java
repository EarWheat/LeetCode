package leetcode.Four.hammingDistance;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/5/27 下午5:36
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int distance = 0;
        while (z > 0){
            if((z & 1) == 1){
                distance++;
            }
            z = z >> 1;
        }
        return distance;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hammingDistance(1,4));
    }
}
