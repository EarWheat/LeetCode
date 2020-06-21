package leetcode.maxPathSum;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-21 09:33
 * @desc:
 *
 * 给定一个非空二叉树，返回其最大路径和。

本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

示例 1:

输入: [1,2,3]

       1
      / \
     2   3

输出: 6
示例 2:

输入: [-10,9,20,null,null,15,7]

   -10                 41
   / \                /  \
  9  20              9   42
    /  \                /  \
   15   7              15   7

输出: 42
*
*
*  -10                 44     // 45 + 9 - 10
   / \                /  \
  9  20              9   45   // 20 + 15 + 10
    /  \                /  \
   15   7              15  10  // 7 + 3
*      / \                 / \
*    -10  3              -10  3
*
*
*  -10                 67      // 29 - 10 + 48              57
   / \                /  \                              /     \
  19  20             29   48   // 20 + 18 + 10         29       38
    /  \                /  \                                 /    \
   15   7      15 + 3  18  10  // 7 + 3                    18     10
*  /   / \             /   / \                            /      /  \
* 3  -10  3           3  -10  3                          3     -10   3
* 思路：构建一个路径最大树，取最大节点即可
 */


public class maxPathSum {

    public static int maxPathSum(TreeNode root) {
        if(root.left == null && root.right == null) {
            return root.val;
        }
        int result = root.val;
        // 还差左右子树小于0，但是值比value大
        if(root.left != null && root.right !=  null){
            int leftValue = singlePathSum(root.left);
            int rightValue = singlePathSum(root.right);
            if(leftValue < 0 && rightValue < 0){
                return Math.max(Math.max(leftValue,rightValue),root.val);
            }
            if(leftValue >= 0){
                result += leftValue;
            }
            if(rightValue > 0){
                result += rightValue;
            }
            return result;
        } else if(root.left != null && root.right == null){
            int leftValue = singlePathSum(root.left);
            if(leftValue >= 0){
                return Math.max(leftValue, root.val + leftValue);
            } else {
                return Math.max(leftValue,root.val);
            }
        } else if(root.left == null && root.right != null){
            int rightValue = singlePathSum(root.right);
            if(rightValue >= 0){
                return Math.max(rightValue, root.val + rightValue);
            } else {
                return Math.max(rightValue,root.val);
            }
        }
        return result;
    }

    // 单路径最大和，即单一路径，节点中没有共同父节点。含该节点
    public static int singlePathSum(TreeNode root){
        int value = root.val;
        if(root.left == null && root.right == null){
            return value;
        }
        if(root.left != null && root.right == null){
            int leftValue = singlePathSum(root.left);
            return leftValue + value;
        } else if(root.right != null && root.left == null){
            int rightValue = singlePathSum(root.right);
            return rightValue + value;
        } else {
            int leftValue = singlePathSum(root.left);
            int rightValue = singlePathSum(root.right);
            return Math.max(leftValue,rightValue) + value;
        }
    }

    // 构建一个路径距离树
    public static TreeNode buildPathTree(TreeNode root){
        if(root.left == null && root.right == null){
            return root;
        }
        int val = root.val;
        int leftValue = 0;
        int rightValue = 0;
        if(root.left != null){
            // 左节点path和大于0
            TreeNode left = buildPathTree(root.left);
            root.left = left;
            leftValue = left.val;
        }
        if(root.right != null){
            // 右节点path和大于0
            TreeNode right = buildPathTree(root.right);
            root.right = right;
            rightValue = right.val;
        }
        val += Math.max(leftValue, rightValue);
        root.val = val;
        return root;
    }

    // 求树中最大节点
    public static int TreeMax(TreeNode root){
        if(root.left == null && root.right == null){
            return root.val;
        }
        int maxValue = root.val;
        if(root.left != null){
            maxValue = Math.max(TreeMax(root.left),maxValue);
        }
        if(root.right != null){
            maxValue = Math.max(TreeMax(root.right),maxValue);
        }
        return maxValue;
    }

//    public static int maxPathSum(TreeNode root) {
//        if(root.left == null && root.right == null) {
//            return root.val;
//        }
//        if(root.val < 0){
//            if(root.left != null && root.right != null){
//                int leftMax = maxPathSum(root.left);
//                int rightMax = maxPathSum(root.right);
//                int max = Math.max(leftMax,rightMax);
//                return Math.max(max,root.val);
//            } else if (root.left != null && root.right == null){
//                return Math.max(maxPathSum(root.left),root.val);
//            } else if(root.right != null && root.left == null){
//                return Math.max(maxPathSum(root.right),root.val);
//            }
//        }
//        int value = root.val;
//        int left = 0;
//        if(root.left != null){
//            left = Math.max(TreeMax(buildPathTree(root.left)),left);
//        }
//        int right = 0;
//        if(root.right != null) {
//            right = Math.max(TreeMax(buildPathTree(root.right)),right);
//        }
//        return value + left + right;
//    }

    /*
                 5                        55         24 + 26 + 5           48
                / \                   /        \                        /       \
               4   8            20+4 24         26    13 + 5 + 8       22       21
              /   / \                /         /  \                   /         / \
             11  13  4       7+2+11 20        13   5    4+1          18        13  5
            / \       \             / \             \               / \             \
           7  2        1           7   2             1             7   2             1
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(8);
        root.left = left;
        root.right = right;
        TreeNode leftL = new TreeNode(11);
        left.left = leftL;
        TreeNode rightL = new TreeNode(13);
        TreeNode rightR = new TreeNode(4);
        right.left = rightL;
        right.right = rightR;
        TreeNode leftLL = new TreeNode(7);
        TreeNode leftLR = new TreeNode(2);
        leftL.left = leftLL;
        leftL.right = leftLR;
        TreeNode rightRR = new TreeNode(1);
        rightR.right = rightRR;
//        System.out.println(singlePathSum(root));
//        System.out.println("answer:48--------"+maxPathSum(root));           // 48

        TreeNode root1 = new TreeNode(-2);
//        TreeNode left1 = new TreeNode(-1);
        TreeNode right1 = new TreeNode(-3);
//        root1.left = left1;
        root1.right = right1;
//        System.out.println(maxPathSum(root1));


        /*
        *  -10                 47      // 9 - 10 + 48              -10
           / \                /  \                              /     \
          9  20              9   48   // 20 + 18 + 10          9       48
            /  \                /  \                                 /    \
            15   7      15 + 3  18  10  // 7 + 3                    18     10
*           /   / \             /   / \                            /      /  \
*          3  -10  3           3  -10  3                          3     -10   3
         */
        TreeNode root3 = new TreeNode(-10);
        TreeNode left3 = new TreeNode(9);
        TreeNode right3 = new TreeNode(20);
        root3.left = left3;
        root3.right = right3;
        TreeNode rightL3 = new TreeNode(15);
        TreeNode rightR3 = new TreeNode(7);
        right3.left = rightL3;
        right3.right = rightR3;
        System.out.println("answer:42----"+maxPathSum(root3));
        TreeNode rightLL3 = new TreeNode(3);
        rightL3.left = rightLL3;
        TreeNode rightRL3 = new TreeNode(-10);
        TreeNode rightRR3 = new TreeNode(3);
        rightR3.left = rightRL3;
        rightR3.right = rightRR3;
        System.out.println("answer:48----"+maxPathSum(root3));


        /*
                1
               / \
              -2 -3
             / \ /
            1  3 -2
           /
          -1
         */
        TreeNode root4 = new TreeNode(1);
        TreeNode left4 = new TreeNode(-2);
        TreeNode right4 = new TreeNode(-3);
        root4.left = left4;
        root4.right = right4;
        TreeNode leftL4 = new TreeNode(1);
        TreeNode leftR4 = new TreeNode(3);
        left4.left = leftL4;
        left4.right = leftR4;
        TreeNode rightL4 = new TreeNode(-2);
        right4.left = rightL4;
        TreeNode leftLL4 = new TreeNode(-1);
        leftL4.left = leftLL4;
        System.out.println(maxPathSum(root4));
    }
}
