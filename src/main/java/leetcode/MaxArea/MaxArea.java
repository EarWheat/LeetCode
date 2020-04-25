package leetcode.MaxArea;

import java.util.HashMap;
import java.util.Map;

/*
 * @author:liuzhaolu
 * @createTime: 2020-04-18 15:40
 * @desc:给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。

图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
*
* 示例：

输入：[1,8,6,2,5,4,8,3,7]
输出：49
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] test = new int[]{1,8,6,2,5,4,8,3,7};      // 49
        int[] test1 = new int[]{1,2,1};     // 2
        int[] test2 = new int[]{1,2,4,3};
//        System.out.println(maxArea(test));
//        System.out.println(maxArea(test1));
        System.out.println(maxArea(test2));
    }

    public static int maxArea(int[] height) {
        if(height.length <= 1){
            return 0;
        }
        int maxArea = 0;
        Map<Integer, Integer> map = findMaxIndex(height);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            // 最高点坐标
            int index = entry.getKey();
            int left,right;
            if(index >= 1){
                left = index - 1;
            } else {
                left = index;
            }
            if(index < height.length - 1){
                right = index + 1;
            } else {
                right = height.length - 1;
            }
            // 向右移动
            while (left >= 0 || right <= height.length - 1){
                if((height[index] - height[left] + height[index] - height[right]) <= (right - left)){
                    maxArea = Math.max(area(height, left, right), maxArea);
                }
                maxArea = Math.max(area(height, left, index), maxArea);
                maxArea = Math.max(area(height, index, right), maxArea);
                if(left > 0){
                    left--;
                }
                if(right < height.length - 1){
                    right++;
                }
            }
        }
        return maxArea;
    }

    private static Map<Integer, Integer> findMaxIndex(int[] height){
        Map<Integer, Integer> map = new HashMap<>();
        int max = height[0];
        for(int i = 1 ; i < height.length; i ++){
            max = Math.max(height[i], max);
        }
        for(int i = 0 ; i < height.length; i++){
            if(max == height[i]){
                map.put(i,height[i]);
            }
        }
        return map;
    }

    // 求面积
    private static int area(int[] height, int start, int end){
        return Math.min(height[start],height[end]) * Math.abs(end - start);

    }

    public static int maxAreaAnswer(int[] height){
        if(height.length <= 1){
            return 0;
        }
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left <= right){

        }
        return maxArea;
    }
}
