package leetcode.History.Trap;

import java.util.Stack;

/*
 * @author:liuzhaolu
 * @createTime: 2020-04-04 17:35
 * @desc:给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
示例:
输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6
 */
public class trap {
    public static void main(String[] args) {
//        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};   // 6
//        int[] height1 = new int[]{4,2,3};        // 1
//        int[] height2 = new int[]{4,2,0,3,2,5}; // 9
//        int[] height3 = new int[]{4,2,0,3,2,4,3,4}; // 10
//        int[] height4 = new int[]{4,9,4,5,3,2};     // 1
        int[] height5 = new int[]{0,7,1,4,6};   // 7
//        System.out.println(trap(height));
//        System.out.println(trap(height1));
//        System.out.println(trap(height2));
//        System.out.println(trap(height3));
//        System.out.println(trap(height4));
        System.out.println(trap(height5));
    }

    public static int trap(int[] height) {
        int result = 0;
        // 从第1个开始，看左右两块板
        for(int i = 1; i < height.length;i++){
            if(height[i-1] > height[i]){
                for(int j = i + 1; j < height.length; j++){
                    // 右边比当前高的高度
                    if(height[j] > height[i] && height[j] >= height[i-1]){
                        // 计算面积
                        result += are(i - 1,j,height);
                        i = j;
                        break;
                    }
                    if(height[j] > height[i] && height[j] < height[i-1]){
                        int k = j;
                        while (k < height.length - 1 && height[k] < height[i-1]){
                            k++;
                        }
                        if(k == height.length - 1){
                            if(height[k] > height[i-1]){
                                result += are(i -1, k, height);
                                return result;
                            } else {
                                result += are(i - 1,j,height);
                                i = j;
                                break;
                            }
                        }
                        result += are(i -1, k, height);
                        i = k;
                        break;
                    }
                }
            }
        }
        return result;
    }

    // 计算面积
    private static int are(int start, int end, int[] height){
        // 最大面积减去占的体积
        int result = Math.min(height[start],height[end]) * (end - start - 1);
        for(int i = start + 1; i < end; i++){
            result = result - height[i];
        }
        return result;
    }

    // 答案
    public int trapAnswer(int[] height) {
        if (height == null) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int curIdx = stack.pop();
                while (!stack.isEmpty() && height[stack.peek()] == height[curIdx]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    int stackTop = stack.peek();
                    ans += (Math.min(height[stackTop], height[i]) - height[curIdx]) * (i - stackTop - 1);
                }
            }
            stack.add(i);
        }
        return ans;
    }
}
