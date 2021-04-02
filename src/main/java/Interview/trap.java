package Interview;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/4/2 上午7:26
 * @desc 面试题 17.21. 直方图的水量
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class trap {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    public int calculateHeight(int[] height, int left, int right){
        if(right - left == 1 || left >= right){
            return 0;
        }
        int middle = 0;int result = 0;int max = 0;
        for (int i = left; i < right; i++) {
            if(height[i] > max){
                max = height[i];
                middle = i;
            }
        }
        max = 0;
        for (int i = left; i < middle; i++) {
            if(height[i] > max){
                max = height[i];
                left = i;
            }
        }
        result += calculateV(height,left,middle);
        result += calculateHeight(height,0,left + 1);
        max = 0;
        for (int i = middle + 1; i < right; i++) {
            if(height[i] > max){
                max = height[i];
                right = i;
            }
        }
        result += calculateV(height,middle,right);
        result += calculateHeight(height,right,height.length);
        return result;
    }

    // 计算left -> right之间的装水体积
    public int calculateV(int[] height, int left, int right){
        int result = 0;
        for (int i = left + 1; i < right; i++) {
            result += height[left] - height[i];
        }
        return result;
    }

    public static void main(String[] args) {
        trap trap = new trap();
        System.out.println(trap.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trap.trap(new int[]{0,0,0,0,0,0}));
        System.out.println(trap.trap(new int[]{}));
        System.out.println(trap.trap(new int[]{10,9,8,7,6}));
        System.out.println(trap.trap(new int[]{10,6,7,4,12}));
    }
}
