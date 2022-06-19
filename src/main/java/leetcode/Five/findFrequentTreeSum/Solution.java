package leetcode.Five.findFrequentTreeSum;

import leetcode.Util.TreeNode;

import java.util.*;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/6/19 3:52 PM
 * @Version: 1.initial version; 2022/6/19 3:52 PM
 */
public class Solution {

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> result = new HashMap<>();
        countSubTreeNodeSum(result, root);
        int max = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : result.entrySet()){
            max = Math.max(max, entry.getValue());
        }
        for(Map.Entry<Integer, Integer> entry : result.entrySet()){
            if(entry.getValue() == max){
                list.add(entry.getKey());
            }
        }
        int[] resp = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            resp[i] = list.get(i);
        }
        return resp;
    }

    public void countSubTreeNodeSum(Map<Integer, Integer> result , TreeNode root){;
        int subTreeNodeSum = subTreeSum(root);
        if (result.containsKey(subTreeNodeSum)) {
            result.put(subTreeNodeSum, result.get(subTreeNodeSum) + 1);
        } else {
            result.put(subTreeNodeSum, 1);
        }
        if(root.left != null){
            countSubTreeNodeSum(result, root.left);
        }
        if(root.right != null){
            countSubTreeNodeSum(result, root.right);
        }
    }

    public int subTreeSum(TreeNode node) {
        int result = node.val;
        if (node.left == null && node.right == null) {
            return result;
        }
        if (node.left != null) {
            result += subTreeSum(node.left);
        }
        if (node.right != null) {
            result += subTreeSum(node.right);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode nodeS1 = new TreeNode(-1);
        TreeNode node2 = new TreeNode(2);
        TreeNode nodeS5 = new TreeNode(-5);
        node5.left = node1;
        node5.right = node2;
        node1.left = nodeS1;
        node1.right = nodeS5;
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findFrequentTreeSum(node5)));
    }
}
