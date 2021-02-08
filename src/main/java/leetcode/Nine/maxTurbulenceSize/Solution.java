package leetcode.Nine.maxTurbulenceSize;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/2/8 上午10:13
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if(arr.length <= 1){
            return arr.length;
        }
        int left = 0;
        int right = 1;
        int preNum; // 前一个数
        int result = 1;
        boolean nextArrIsBigger; // 湍流下一个数是否要大
        while (left < arr.length && right < arr.length){
            if(arr[left] == arr[right]){
                left++;
                right++;
                continue;
            }
            preNum = arr[left]; // 前一个数
            nextArrIsBigger = arr[right] <= preNum;
            preNum = arr[right];
            result = Math.max(result,right - left + 1);
            right++;
            while (right < arr.length){
                if(arr[right] > preNum){  // 后面的数比前一个数大
                    if(nextArrIsBigger){    // 并且与湍流要求相符
                        nextArrIsBigger = false;
                    } else {
                        result = Math.max(result,right - left);
                        left = right - 1;
                        break;
                    }
                } else if (arr[right] < preNum){
                    if(!nextArrIsBigger){
                        nextArrIsBigger = true;
                    } else {
                        result = Math.max(result,right - left);
                        left = right - 1;
                        break;
                    }
                } else {
                    result = Math.max(result,right - left);
                    left = right - 1;
                    break;
                }
                preNum = arr[right];
                right++;
            }
        }
        return Math.max(result, right - left);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{4,8,12,16};
        int[] arr2 = new int[]{9,4,2,10,7,8,8,1,9};
        int[] arr3 = new int[]{9,9};
        int[] arr4 = new int[]{0,8,45,88,48,68,28,55,17,24};
        System.out.println(solution.maxTurbulenceSize(arr4));
    }


}
