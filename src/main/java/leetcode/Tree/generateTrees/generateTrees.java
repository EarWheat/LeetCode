package leetcode.Tree.generateTrees;


import UtilClass.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-21 16:08
 * @desc:给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。

 

示例：

输入：3
输出：
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
解释：
以上的输出对应以下 5 种不同结构的二叉搜索树：

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3


* 题目类似numTrees
* 位置leetcode.Tree.numTrees
 */
public class generateTrees {

    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        if(n == 0){
            return null;
        }
        return buildTree(1,n);
    }

    private static List<TreeNode> buildTree(int left, int right){
        List<TreeNode> result = new ArrayList<>();
        if(left > right){
            result.add(null);
            return result;
        }
        if(left == right){
            result.add(new TreeNode(left));
            return result;
        }
        for(int i = left; i <= right; i++){

            // 左子树集合
            List<TreeNode> leftList = buildTree(left,i -1);
            List<TreeNode> rightList = buildTree(i + 1, right);
            // 左子树集合不为空
            for(TreeNode leftNode : leftList){
                for(TreeNode rightNode : rightList){
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    result.add(root);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<TreeNode> result = generateTrees(3);
        for(TreeNode treeNode : result){
            System.out.println(treeNode.val);
        }
    }
}
