package leetcode.Tree.rob;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-05 11:27
 * @desc:
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。

计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

示例 1:

输入: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \
     3   1

输出: 7
解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
示例 2:

输入: [3,4,5,1,3,null,1]

     3               3/0
    / \              / \
   4   5           4/3 5/3
  / \   \          / \  / \
 1   3   1

输出: 9
解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.

思路：
* 动态规划：
* dp[i][j][0]:表示第i层第j个数不偷取时最大值
* dp[i][j][1]:表示第i层第j个数偷取时最大值
* dp[0][0][0] = 0;
* dp[0][0][1] = 0;
* dp[1][1][0] = 0;
* dp[1][1][1] = 3;
* dp[2][1][0] = dp[1][1][1]
* dp[2][1][1] = dp[1][1][0] + node.value;
* dp[2][2]
* 树转换成数组，用染色算法，相连节点染不同色
* [1,4,3,3,null,5,1]
 */
public class rob {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int rob(TreeNode root) {
        //递归思想（不要深入递归函数体，只需知道递归函数的功能，以及找到跳出递归的边界条件）
        //思路：
        //能盗取的最高金额为 抢劫该节点+抢劫该节点的左孩子的左右子树+抢劫该节点的右孩子的左右子树
        //与 抢劫该节点的左子树+抢劫该节点的右子树的和  的最大值
        if(root == null) return 0;
        int val = 0;
        if(root.left != null) val += rob(root.left.left) + rob(root.left.right);
        if(root.right != null) val += rob(root.right.left) + rob(root.right.right);
        return Math.max(rob(root.left) + rob(root.right),val + root.val);
    }
}
