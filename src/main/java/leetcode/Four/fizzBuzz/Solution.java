package leetcode.Four.fizzBuzz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/10/13 4:26 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public List<String> fizzBuzz(int n) {
        LinkedList<String> result = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(i % 15 == 0){
                result.add("FizzBuzz");
            } else if(i % 5 == 0){
                result.add("Buzz");
            } else if(i % 3 == 0){
                result.add("Fizz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
}
