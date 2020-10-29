package leetcode.One.sumNumbers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-10-29 11:25
 * @desc 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 *
 * 输入: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 *
 *
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class sumNumbers {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 思路：当前节点值 * 节点深度 * 10 + 左右子节点的值
     * @param root
     * @return
     */
    public static int sumNumbers(TreeNode root) {
        int result = 0;
        if(root == null){
            return result;
        }
        List<LinkedList<Integer>> nodeList = nodeWay(root);
        for(LinkedList<Integer> way:nodeList){
            int temp = 0;
            for(int i = 0; i < way.size(); i++){
                temp += way.get(i) * Math.pow(10,i);
            }
            result += temp;
        }
        return result;
    }

    public static List<LinkedList<Integer>> nodeWay(TreeNode root){
        List<LinkedList<Integer>> nodeWay = new ArrayList<LinkedList<Integer>>();
        if(root == null){
            return nodeWay;
        }
        if(root.left != null){
            List<LinkedList<Integer>> leftWay = nodeWay(root.left);
            for(LinkedList<Integer> way : leftWay){
                way.add(root.val);
            }
            nodeWay.addAll(leftWay);
        }
        if(root.right != null){
            List<LinkedList<Integer>> rightWay = nodeWay(root.right);
            for(LinkedList<Integer> way : rightWay){
                way.add(root.val);
            }
            nodeWay.addAll(rightWay);
        }
        // 根节点
        if(root.left == null && root.right == null){
            LinkedList<Integer> way = new LinkedList<Integer>();
            way.add(root.val);
            List<LinkedList<Integer>> ways = new ArrayList<LinkedList<Integer>>();
            ways.add(way);
            nodeWay.addAll(ways);
        }
        return nodeWay;
    }

    /**
     *  *     4
     *  *    / \
     *  *   9   0
     *  *  / \
     *  * 5   1
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node9 = new TreeNode(9);
        TreeNode node0 = new TreeNode(0);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        node4.right = node0;
        node4.left = node9;
        node9.left = node5;
        node9.right = node1;
        System.out.println(sumNumbers(node4));
    }

}
