package leetcode.One.Thousand.getAllElements;


import leetcode.Util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Desc: https://leetcode.cn/problems/all-elements-in-two-binary-search-trees/
 * @Author: 泽露
 * @Date: 2022/5/1 5:29 PM
 * @Version: 1.initial version; 2022/5/1 5:29 PM
 */
public class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = midOrder(root1);
        List<Integer> list2 = midOrder(root2);
        List<Integer> result = new ArrayList<>();
        int i = 0; int j = 0;
        while (i < list1.size() && j < list2.size()){
            if(list1.get(i) < list2.get(j)){
                result.add(list1.get(i));
                i++;
            } else {
                result.add(list2.get(j));
                j++;
            }
        }
        while (i < list1.size()){
            result.add(list1.get(i++));
        }
        while (j < list2.size()){
            result.add(list2.get(j++));
        }
        return result;
    }

    public List<Integer> midOrder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root != null){
            result.addAll(midOrder(root.left));
            result.add(root.val);
            result.addAll(midOrder(root.right));
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node0 = new TreeNode(0);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node11 = new TreeNode(1);
        node2.left = node1;
        node2.right = node4;
        node11.left = node0;
        node11.right = node3;
        Solution solution = new Solution();
        System.out.println(solution.getAllElements(node2, node11));
    }
}
