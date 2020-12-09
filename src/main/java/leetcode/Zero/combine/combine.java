package leetcode.Zero.combine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-09-08 17:03
 * @desc 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * @prd Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class combine {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(k > n){
            return result;
        }
        if(k == 1){
            List<Integer> temp;
            for(int i = 0; i < n; i++){
                temp = new ArrayList<>();
                temp.add(i + 1);
                result.add(temp);
            }
            return result;
        }
        // n - 1个数构建k的组合 ----- 【1,3][2,3][1,2]
        List<List<Integer>> before2 = combine(n - 1, k);
        // 用n-1 构建k-1个数,再原有的所有组合上新增n ------ [1][2][3] + 4 == [1,4][2,4][3,4]
        List<List<Integer>> before = combine(n - 1, k -1);
        for(List<Integer> list : before){
            list.add(n);
            result.add(list);
        }
        result.addAll(before2);
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = combine(4,2);
        System.out.println(result.toString());
        List<List<Integer>> temp = combine(3,1);
        System.out.println(temp.toString());
    }
}
