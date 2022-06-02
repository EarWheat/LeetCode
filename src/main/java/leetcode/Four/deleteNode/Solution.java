package leetcode.Four.deleteNode;

import leetcode.Util.TreeNode;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/6/2 3:10 PM
 * @Version: 1.initial version; 2022/6/2 3:10 PM
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }
        TreeNode temp;
        TreeNode tempFatherNode = root;
        if(root.val > key){
            temp = root.left;
        } else if(root.val == key){
            return mergeTree(root.left, root.right);
        } else {
            temp = root.right;
        }
        while (temp != null && temp.val != key){
            if(temp.val > key){
                tempFatherNode = temp;
                temp = temp.left;
            } else {
                tempFatherNode = temp;
                temp = temp.right;
            }
        }
        if(temp != null && temp.val == key){
            TreeNode left = temp.left;
            TreeNode right = temp.right;
            if(temp == tempFatherNode.left){
                tempFatherNode.left = mergeTree(left, right);
            } else {
                tempFatherNode.right = mergeTree(left, right);
            }
        }
        return root;
    }

    //                    8
    //               5        11                   10             5
    //              / \      /  \                 /  \           /      \
    //             2   7    9   12               5   12         2       11
    //              \      /                     / \            \      /  \
    //               3    8                     2   7           3     9    12
    //                                          \   \                 /
    //                                           3   9               8
    //                                                             /
    //                                                            7
    // 右旋
    public TreeNode mergeTree(TreeNode left, TreeNode right){
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        // 如果左节点的右子树为空，直接合并
        if(left.right == null){
            left.right = right;
        } else {
            // 需要摘出右字树做合并
            TreeNode temp = left.right;
            left.right = right;
            // 合并到右子树的某个节点下
            if(right.left == null){
                right.left = temp;
                return left;
            }
            TreeNode preParent = right;
            TreeNode rightParent = preParent.left;
            while (rightParent.left != null && temp.val < rightParent.left.val){
                rightParent = rightParent.left;
            }
            // 非平衡二叉树
            if(preParent.right == null){
                preParent.right = rightParent;
                preParent.left = temp;
            } else {
                rightParent.left = temp;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node6 = new TreeNode(6);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        node5.left = node3;
        node5.right = node6;
        node3.left = node2;
        node3.right = node4;
        node6.right = node7;
        Solution solution = new Solution();
        System.out.println(solution.deleteNode(node5,5).val);
    }
}
