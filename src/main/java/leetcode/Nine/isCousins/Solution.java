package leetcode.Nine.isCousins;

import leetcode.Util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/5/17 下午2:33
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        return isContains(queue,x,y);
    }

   public boolean isContains(Queue<TreeNode> queue, int x, int y){
       if(queue.isEmpty()){
           return false;
       }
       List<Integer> nodes = new ArrayList<>();
       Queue<TreeNode> newNodeQueue = new LinkedBlockingQueue<>();
       while (!queue.isEmpty()){
           TreeNode node = queue.poll();
           if(node.left == null && node.right == null){
               continue;
           }
           int left = 0 ,right = 0;
           if(node.left != null){
               left = node.left.val;
           }
           if(node.right != null){
               right = node.right.val;
           }
           if((left == x && right == y) || (left == y && right == x)){
               return false;
           }
           nodes.add(left);
           nodes.add(right);
           if(node.left != null){
               newNodeQueue.add(node.left);
           }
           if(node.right != null){
               newNodeQueue.add(node.right);
           }
       }
       if(nodes.contains(x) && nodes.contains(y)){
           return true;
       } else {
           return isContains(newNodeQueue,x,y);
       }
   }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode nodeLeft = new TreeNode(2);
        TreeNode nodeRight = new TreeNode(3);
        TreeNode nodeLeftRight= new TreeNode(4);
        node.left = nodeLeft;
        node.right = nodeRight;
        nodeLeft.right = nodeLeftRight;
        Solution solution = new Solution();
        System.out.println(solution.isCousins(node,2,3));
    }
}
