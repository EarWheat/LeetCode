package leetcode.Tree.flatten;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-02 14:48
 * @desc:
 * 给定一个二叉树，原地将它展开为一个单链表。

 

例如，给定二叉树

    1
   / \
  2   5
 / \   \
3   4   6
将其展开为：

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
在计算机科学中，一个原地算法（in-place algorithm）是一种使用小的，固定数量的额外之空间来转换资料的算法。当算法执行时，输入的资料通常会被要输出的部份覆盖掉。不是原地算法有时候称为非原地（not-in-place）或不得其所（out-of-place）。
思路：
* 思路：
* 前序遍历转链表

 */
public class flatten {
     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

     //            1                      1
   //             / \                      \
  //             2   6                      2
  //            / \  / \                   / \
  //           3   4 7 8                  3   4
 //                 \                          \
  //                 5                          5
    //                                           \
    //                                            6
    //                                           / \
    //                                          7   8
    public static void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            root.right = left;
            while (left.right != null) left = left.right;
            left.right = right;
            root.left = null;
        }
    }



    public static void main(String[] args) {

    }
}
