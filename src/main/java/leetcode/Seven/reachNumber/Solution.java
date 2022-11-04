package leetcode.Seven.reachNumber;
//在一根无限长的数轴上，你站在0的位置。终点在target的位置。
//
// 你可以做一些数量的移动 numMoves :
//
//
// 每次你可以选择向左或向右移动。
// 第 i 次移动（从 i == 1 开始，到 i == numMoves ），在选择的方向上走 i 步。
//
//
// 给定整数 target ，返回 到达目标所需的 最小 移动次数(即最小 numMoves ) 。
//
//
//
// 示例 1:
//
//
//输入: target = 2
//输出: 3
//解释:
//第一次移动，从 0 到 1 。
//第二次移动，从 1 到 -1 。
//第三次移动，从 -1 到 2 。
//
//
// 示例 2:
//
//
//输入: target = 3
//输出: 2
//解释:
//第一次移动，从 0 到 1 。
//第二次移动，从 1 到 3 。
//
//
//
//
// 提示:
//
//
// -10⁹ <= target <= 10⁹
// target != 0
//
// Related Topics 数学 二分查找 👍 291 👎 0

import java.util.*;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/11/4 2:21 PM
 * @Version: 1.initial version; 2022/11/4 2:21 PM
 */
public class Solution {
    public int reachNumber(int target) {
        if (target <= 1) {
            return target;
        }
        // step, nums
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> origin = new HashSet<>();
        origin.add(1);
        origin.add(-1);
        map.put(1, origin);
        int step = 1;
        while (true){
            Set<Integer> list = map.get(step);
            if(list.contains(target)){
                return step;
            }
            step++;
            Set<Integer> temp = new HashSet<>();
            for (Integer source : list) {
                temp.add(source - step);
                temp.add(source + step);
            }
            map.put(step, temp);
        }
    }

    public int reachNumberV2(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0) {
            k++;
            target -= k;
        }
        return target % 2 == 0 ? k : k + 1 + k % 2;
    }
}
