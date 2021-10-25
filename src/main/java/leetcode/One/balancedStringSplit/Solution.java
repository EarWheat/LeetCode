package leetcode.One.balancedStringSplit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/7 4:56 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    // L : -1
    // R : 1;
    public int balancedStringSplit(String s) {
        int result = 0;
        int index = 0;
        int temp = 0;
        while (index < s.length()){
            if(s.charAt(index) == 'L'){
                temp -= 1;
            }
            if(s.charAt(index) == 'R'){
                temp += 1;
            }
            if(temp == 0){
                result++;
            }
            index++;
        }
        return result;
    }
}
