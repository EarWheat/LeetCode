package leetcode.Three.shuffle;

import java.util.Random;

/**
 * @author ：liuzhaolu
 * @date ：2021/11/22 6:23 下午
 * @desc ：
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 * 2021/11/22      liuzhaolu       firstVersion
 */
public class Solution {
    int[] array;
    int[] original;

    private Random rand = new Random();

    private void swap(int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public Solution(int[] nums) {
        array = nums;
        original = array.clone();
    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return array;
    }
    //Jdk  Collections.shuffle()方法
    public int[] shuffle() {
        for(int i=array.length;i>1;i--){
            swap(i-1, rand.nextInt(i));
        }

        return array;
    }
}
