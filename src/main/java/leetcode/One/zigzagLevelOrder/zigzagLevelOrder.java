package leetcode.One.zigzagLevelOrder;

import com.alibaba.fastjson.JSONObject;
import leetcode.Util.TreeNode;
import leetcode.Util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-22 18:03
 * @desc 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class zigzagLevelOrder {
    /**
     *  *     3
     *  *    / \
     *  *   9  20
     *  *     /  \
     *  *    15   7
     * @param root
     * @return
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        return print(stack,0);
    }

    public static List<List<Integer>> print(Stack<TreeNode> stack, int level){
        List<List<Integer>> result = new ArrayList<>();
        if(stack.size() == 0){
            return result;
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> newStack = new Stack<>();
        while (stack.size() != 0){
            TreeNode temp = stack.pop();
            list.add(temp.val);
            if(level % 2 == 0){
                // 先入左节点，后入右节点
                if(temp.left != null){
                    newStack.push(temp.left);
                }
                if(temp.right != null){
                    newStack.push(temp.right);
                }
            } else {
                // 先入右节点，后入左节点
                if(temp.right != null){
                    newStack.push(temp.right);
                }
                if(temp.left != null){
                    newStack.push(temp.left);
                }
            }
        }
        result.add(list);
        result.addAll(print(newStack,++level));
        return result;
    }

    /**
     *      *  *     3
     *      *  *    / \
     *      *  *   9  20
     *      *  *     /  \
     *      *  *    15   7
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode rightLeft = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);
        root.left = left;
        root.right = right;
        right.left = rightLeft;
        right.right = rightRight;
        System.out.println(JSONObject.toJSONString(zigzagLevelOrder(root)));
    }
}
