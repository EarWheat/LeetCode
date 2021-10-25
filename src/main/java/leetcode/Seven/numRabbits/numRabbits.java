package leetcode.Seven.numRabbits;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/4/4 下午1:13
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class numRabbits {
    public int numRabbits(int[] answers) {
        if(answers == null){
            return 0;
        }
        // 先聚类，和计数
        Map<Integer, Integer> rabbitsCluster = new HashMap<>(); // 一共有value个说和自己有key个相同的颜色
        for (int i = 0; i < answers.length; i++) {
            if(rabbitsCluster.containsKey(answers[i])){
                rabbitsCluster.put(answers[i], rabbitsCluster.get(answers[i])+ 1);
            } else {
                rabbitsCluster.put(answers[i],1);
            }
        }
        int result = calculateRabbits(rabbitsCluster);
        return result;
    }

    public int calculateRabbits(Map<Integer, Integer> rabbitsCluster){
        int result = 0;
        for(Map.Entry<Integer, Integer> entry : rabbitsCluster.entrySet()){
            if(entry.getKey() + 1 >= entry.getValue()){
                result += 1 + entry.getKey();
            } else {
                // 一簇有多少只兔子
                int singleCluster = entry.getKey() + 1;
                // 可以分为多少蔟
                int clusters = (int)Math.ceil((double)entry.getValue() / singleCluster);
                result += clusters * singleCluster;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        numRabbits numRabbits = new numRabbits();
//        System.out.println(numRabbits.numRabbits(new int[]{1,1,2}));
        System.out.println(numRabbits.numRabbits(new int[]{1,1,1,2}));
//        System.out.println(numRabbits.numRabbits(new int[]{10,10,10}));
    }
}
