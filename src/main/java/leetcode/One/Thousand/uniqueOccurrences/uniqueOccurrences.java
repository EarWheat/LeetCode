package leetcode.One.Thousand.uniqueOccurrences;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-10-28 17:52
 * @desc 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * 示例 2：
 *
 * 输入：arr = [1,2]
 * 输出：false
 * 示例 3：
 *
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 *
 *
 * 链接：https://leetcode-cn.com/problems/unique-number-of-occurrences
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class uniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> count = new HashMap<Integer, Integer>();
        for (int i : arr){
            if(count.containsKey(i)){
                count.put(i, 1 + count.get(i));
            } else {
                count.put(i,1);
            }
        }
        Set<Integer> set = new HashSet<Integer>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()){
            if(set.contains(entry.getValue())){
                return false;
            } else {
                set.add(entry.getValue());
            }
        }
        return true;
    }
}
