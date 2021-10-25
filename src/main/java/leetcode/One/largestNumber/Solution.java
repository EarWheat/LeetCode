package leetcode.One.largestNumber;

import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/4/12 下午7:53
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public static String largestNumber(int[] nums) {
        return Arrays.stream(nums)
                    .boxed()
                    .map(i -> i.toString(i))
                    .sorted((s1, s2)->{
                        String sum1 = s1 + s2;
                        String sum2 = s2 + s1;

                        for(int i = 0; i < sum1.length(); i++){
                            if(sum1.charAt(i) != sum2.charAt(i)){
                                return sum2.charAt(i) - sum1.charAt(i);
                            }
                        }
                        return 0;
                    })
                    .reduce(String::concat)
                    .filter(s->!s.startsWith("0"))
                    .orElse("0");

    }

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{111311, 1113}));
    }
}
