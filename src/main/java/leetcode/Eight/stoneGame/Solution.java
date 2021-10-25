package leetcode.Eight.stoneGame;

import java.util.Arrays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/6/16 下午3:58
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public boolean stoneGame(int[] piles) {
        if(piles.length <= 2){
            return true;
        }
        int stoneMax = stoneMax(piles);
        return Arrays.stream(piles).sum() - stoneMax < stoneMax;
    }

    public int stoneMax(int[] piles){
        if(piles.length == 1){
            return piles[0];
        }
        if(piles.length == 2){
            return Math.max(piles[0],piles[1]);
        }
        // 拿左侧
        int left = piles[0];
        int[] newPiles = Arrays.copyOfRange(piles,1,piles.length);
        left += Arrays.stream(newPiles).sum() - stoneMax(newPiles);
        int right = piles[piles.length - 1];
        newPiles = Arrays.copyOfRange(piles,0,piles.length - 1);
        right += Arrays.stream(newPiles).sum() - stoneMax(newPiles);
        return Math.max(left,right);
    }

    public static void main(String[] args) {
        int[] stones = new int[]{5,3,4,5};
        Solution solution = new Solution();
        System.out.println(solution.stoneGame(stones));
    }
}
