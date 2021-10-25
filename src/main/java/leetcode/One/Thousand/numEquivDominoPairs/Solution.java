package leetcode.One.Thousand.numEquivDominoPairs;

import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/1/26 下午2:13
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    /**
     * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
     * 输出：1
     */
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> allDomino = new HashMap<>(); // 用于存储多米诺骨牌
        // 将所有多米诺按从小到大旋转
        for (int[] domino : dominoes) {
            order(domino);
            String name = getDominoesName(domino);
            if (allDomino.containsKey(name)) {
                allDomino.put(name, allDomino.get(name) + 1);
            } else {
                allDomino.put(name, 1);
            }
        }
        int result = 0;
        // 2 -> 1
        // 3 -> 3  2 + 1
        // 4 -> 6  3 + 2 + 1
        for(Map.Entry<String, Integer> entry : allDomino.entrySet()){
            if(entry.getValue() > 1){
                result += couple(entry.getValue());
            }
        }
        return result;
    }

    public int couple(int n){
        int result = 0;
        n--;
        while (n > 0){
            result += n;
            n--;
        }
        return result;
    }

    // 多米诺按从小到大旋转
    public void order(int[] domino){
        if(domino[0] > domino[1]){
            int temp = domino[1];
            domino[1] = domino[0];
            domino[0] = temp;
        }
    }

    public String getDominoesName(int[] domino){
        return domino[0] + "_" + domino[1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.couple(3));
        System.out.println(solution.couple(2));
        System.out.println(solution.couple(4));
    }
}
