package leetcode.One.Thousand.simplifiedFractions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：liuzhaolu
 * @description：1447. 最简分数
 * @prd : https://leetcode-cn.com/problems/simplified-fractions/
 * @date ：2022/2/10 10:48 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/2/10 10:48 上午     liuzhaolu       firstVersion
 */
public class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if(simplified(i,j)){
                    result.add(j + "/" + i);
                }
            }
        }
        return result;
    }

    // 是否最简分数
    public boolean simplified(int i, int j){
        if(i % j == 0 && j != 1){
            return false;
        }
        for (int k = 2; k < j; k++) {
            if(i % k == 0 && j % k == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifiedFractions(4));
    }
}
