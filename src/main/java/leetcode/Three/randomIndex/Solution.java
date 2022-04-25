package leetcode.Three.randomIndex;

import java.util.Random;

/**
 * @author ：liuzhaolu
 * @description：398. 随机数索引
 * @prd : https://leetcode-cn.com/problems/random-pick-index/
 * @date ：2022/4/25 4:57 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/4/25 4:57 下午     liuzhaolu       firstVersion
 */
public class Solution {
    int[]arr;
    public Solution(int[] nums) {
        arr=nums.clone();
    }
    public int pick(int target) {
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target) count++;
        }
        int choose=new Random().nextInt(count)+1;
        count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                count++;
                if(count==choose) return  i;
            }
        }
        return  -1;
    }
}
