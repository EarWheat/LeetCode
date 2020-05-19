package leetcode.levelOrder;


import java.util.*;

/*
 * @author:liuzhaolu
 * @createTime: 2020-05-13 18:29
 * @desc:给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

 

示例：
二叉树：[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]

* 思路：用队列递归
* step1: 3加入List,    9, 20 入栈
* step2: 9，20出队列并加入List, 9的左右入队列, 15 7入队
 */
public class levelOrder {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return result;
        }
        // 先入队列
        queue.offer(root);
        return currentOrder(queue,result);
    }

    public static List<List<Integer>> currentOrder(Queue<TreeNode> queue, List<List<Integer>> result){
        List<Integer> current = new ArrayList<>();
        Queue<TreeNode> newQueue = new LinkedList<>();
        // 遍历队列
        for (TreeNode treeNode : queue){
            current.add(treeNode.val);
            if(treeNode.left != null){
                newQueue.offer(treeNode.left);
            }
            if(treeNode.right != null){
                newQueue.offer(treeNode.right);
            }
        }
        result.add(current);
        if(newQueue.size() != 0){
            currentOrder(newQueue,result);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode rightL = new TreeNode(15);
        TreeNode rightR = new TreeNode(7);
        root.left = left;
        root.right = right;
        right.left = rightL;
        right.right = rightR;
        System.out.println(levelOrder(root).toString());
    }
}
