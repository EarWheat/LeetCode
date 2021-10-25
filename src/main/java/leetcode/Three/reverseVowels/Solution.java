package leetcode.Three.reverseVowels;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/8/19 10:34 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        String temp = "aeiouAEIOU";
        StringBuilder stringBuilder = new StringBuilder(s);
        while (left <= right){
            char t = s.charAt(left);
            if(temp.contains(String.valueOf(t))){
                while (right >= left){
                    char k = s.charAt(right);
                    if(temp.contains(String.valueOf(k))){
                        swap(stringBuilder,left,right);
                        right--;
                        break;
                    }
                    right--;
                }
            }
            left++;
        }
        return stringBuilder.toString();
    }

    private void swap(StringBuilder s, int i, int j){
        char t = s.charAt(i);
        s.replace(i,i+1,String.valueOf(s.charAt(j)));
        s.replace(j,j+1,String.valueOf(t));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseVowels("race car"));
    }
}
