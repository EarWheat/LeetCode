package leetcode.Nine.minDeletionSize;

/**
 * @Desc: https://leetcode.cn/problems/delete-columns-to-make-sorted/
 * @Author: 泽露
 * @Date: 2022/5/12 2:34 PM
 * @Version: 1.initial version; 2022/5/12 2:34 PM
 */
public class Solution {
    public int minDeletionSize(String[] strs) {
        if(strs.length <= 0){
            return 0;
        }
        int result = 0;
        boolean[] del = new boolean[strs[0].length()];
        for (int i = 0; i < strs[0].length(); i++) {
            del[i] = true;
        }
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if(del[i]){
                    if(strs[j].charAt(i) - strs[j - 1].charAt(i) < 0){
                        del[i] = false;
                    }
                }
            }
        }
        for (int i = 0; i < del.length; i++) {
            if(!del[i]){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"abc", "bce", "cae"};
        Solution solution = new Solution();
        System.out.println(solution.minDeletionSize(strings));
    }
}
