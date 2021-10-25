package leetcode.Four.minMoves;

public class Solution {
    public int[] plusOne(int[] digits) {
        int temp = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + temp;
            if(digits[i] < 10){
                break;
            } else {
                if(i == 0){
                    digits = moveDigits(digits);
                    break;
                }
                digits[i] = 0;
            }
        }
        return digits;
    }

    private int[] moveDigits(int[] digits){
        int[] result = new int[digits.length + 1];
        if(result.length == 2){
            return new int[]{1,0};
        }
        result[0] = 1;
        result[1] = 0;
        for (int i = 2; i < result.length; i++) {
            result[i] = digits[i - 1];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.plusOne(new int[]{9}).toString());
    }
}
