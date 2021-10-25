package leetcode.Tree.binaryTreePaths;

import UtilClass.Tree;

import java.util.ArrayList;
import java.util.List;

/*
 * @author:liuzhaolu
 * @createTime: 2020-09-04 15:29
 * @desc:
 */
public class binaryTreePaths {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if(root.left == null && root.right == null){
            result.add(String.valueOf(root.val));
            return result;
        }
        if(root.left != null){
            for(String str : binaryTreePaths(root.left)){
                stringBuilder.append(root.val);
                stringBuilder.append("->");
                stringBuilder.append(str);
                result.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            }
        }
        if(root.right != null){
            for(String str : binaryTreePaths(root.right)){
                stringBuilder.append(root.val);
                stringBuilder.append("->");
                stringBuilder.append(str);
                result.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            }
        }
        return result;
    }

    /**
     *    1
     *  /   \
     * 2     3
     *  \
     *   5
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode leftLeft = new TreeNode(4);
        TreeNode leftRight = new TreeNode(5);
        root.left = left;
        root.right = right;
        left.right = leftRight;
        left.left = leftLeft;
        binaryTreePaths binaryTreePaths = new binaryTreePaths();
        List<String> result = binaryTreePaths.binaryTreePaths(root);
        System.out.println(result.toString());
    }
}
