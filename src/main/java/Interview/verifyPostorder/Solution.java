package Interview.verifyPostorder;

import leetcode.Util.TreeNode;

import java.util.Arrays;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/6/10 11:23 AM
 * @Version: 1.initial version; 2022/6/10 11:23 AM
 */
public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder.length == 0){
            return false;
        }
        if(postorder.length == 1){
            return true;
        }
        int index = postorder[postorder.length - 1];
        int i = 0;
        while (i < postorder.length){
            if(postorder[i] >= index){
                break;
            }
            i++;
        }
        int[] leftArray = Arrays.copyOfRange(postorder,0, i);
        int[] rightArray = Arrays.copyOfRange(postorder,i, postorder.length - 1);
        for (int k : leftArray) {
            if (k > index) {
                return false;
            }
        }
        for (int k : rightArray) {
            if (k < index) {
                return false;
            }
        }
        boolean left = leftArray.length <= 0 || verifyPostorder(leftArray);
        boolean right = rightArray.length <= 0 || verifyPostorder(rightArray);
        return left && right;
    }

    //           4
    //          /
    //         3
    //        / \
    //       1   2

    //           1
    //            \

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node6 = new TreeNode(6);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node5.left = node2;
        node5.right = node6;
        node2.left = node1;
        node2.right = node3;
        Solution solution = new Solution();
//        System.out.println(solution.verifyPostorder(new int[]{4, 8, 6, 12, 16, 14, 10}));
        System.out.println(solution.verifyPostorder(new int[]{1,2,3,4,5}));
        //                              5
        //                            /  \
        //                           1    2
        //                                 \
        System.out.println(solution.verifyPostorder(new int[]{1,6,3,2,5}));
    }
}
