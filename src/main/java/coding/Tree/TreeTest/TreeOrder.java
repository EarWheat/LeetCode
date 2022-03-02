package coding.Tree.TreeTest;


import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author ：liuzhaolu
 * @description：树的前序、中序、后序遍历
 * @prd :
 * @date ：2022/3/2 2:57 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/2 2:57 下午     liuzhaolu       firstVersion
 */
public class TreeOrder {

    public static class TreeNode {
        String val;
        TreeNode left;
        TreeNode right;

        public TreeNode(String val) {
            this.val = val;
        }
    }

    /**
     * 前序遍历
     *
     * @param treeNode
     * @return
     */
    public static String preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(treeNode.val);
        if (treeNode.left != null) {
            stringBuilder.append(preOrder(treeNode.left));
        }
        if (treeNode.right != null) {
            stringBuilder.append(preOrder(treeNode.right));
        }
        return stringBuilder.toString();
    }

    public static String preOrderV2(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            TreeNode temp = stack.peek();
            stringBuilder.append(temp.val);
            while (temp.left != null) {
                stringBuilder.append(temp.left.val);
                stack.push(temp.left);
                temp = temp.left;
            }
            while (!stack.empty()){
                temp = stack.pop();
                if(temp.right != null){
                    stack.push(temp.right);
                    break;
                }
            }
        }
        return stringBuilder.toString();
    }

    public static String midOrder(TreeNode root){
        if (root == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (root.left != null) {
            stringBuilder.append(midOrder(root.left));
        }
        stringBuilder.append(root.val);
        if (root.right != null) {
            stringBuilder.append(midOrder(root.right));
        }
        return stringBuilder.toString();
    }

    public static String midOrderV2(TreeNode root){
        StringBuilder stringBuilder = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.empty())
        {
            while (root != null)
            {
                stack.push(root);
                root = root.left;
            }
            if(!stack.empty())
            {
                root = stack.pop();
                stringBuilder.append(root.val);
                root = root.right;
            }
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        TreeNode A = new TreeNode("A");
        TreeNode B = new TreeNode("B");
        TreeNode C = new TreeNode("C");
        TreeNode D = new TreeNode("D");
        TreeNode E = new TreeNode("E");
        TreeNode F = new TreeNode("F");
        TreeNode G = new TreeNode("G");
        TreeNode H = new TreeNode("H");
        TreeNode I = new TreeNode("I");
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        D.left = F;
        D.right = G;
        G.left = H;
        G.right = I;
        System.out.println(preOrder(A));
        System.out.println(preOrderV2(A));
        System.out.println(midOrder(A));
        System.out.println(midOrderV2(A));

    }
}
