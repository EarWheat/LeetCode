package leetcode.One.Thousand.lastStoneWeight;

import java.util.Arrays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020/12/30 下午12:18
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class lastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 0){
            return 0;
        }
        if(stones.length == 1){
            return stones[0];
        }
        if(stones.length == 2){
            return Math.abs(stones[1] - stones[0]);
        }
        Arrays.sort(stones);
        int x = stones[stones.length - 2];
        int y = stones[stones.length - 1];
        // y >= x
        if(x == y){
            return lastStoneWeight(Arrays.copyOfRange(stones,0,stones.length - 2));
        } else {
            stones[stones.length - 2] = y - x;
            return lastStoneWeight(Arrays.copyOfRange(stones,0,stones.length - 1));
        }
    }


}
