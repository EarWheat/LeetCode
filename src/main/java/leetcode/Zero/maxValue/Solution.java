package leetcode.Zero.maxValue;

import leetcode.Util.TreeNode;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/8/8 12:13 PM
 * @Version: 1.initial version; 2022/8/8 12:13 PM
 */
public class Solution {
    // 5,2,4,null,3
    // 4,2,5,3
    public int maxValue(TreeNode root, int k) {
        String result = preOrder(root);
        String[] split = result.split(",");
        int[] val = new int[split.length];
        for (int i = 0; i < val.length; i++) {
            val[i] = Integer.parseInt(split[i]);
        }
        // 0表示不染色，1表示染色
        int[][] dp = new int[val.length][2];
        dp[0][0] = 0;
        dp[0][1] = val[0];
        for (int i = 1; i < val.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + val[i];
        }
        return Math.max(dp[val.length - 1][0], dp[val.length - 1][1]);
    }

    public String preOrder(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (root.left != null) {
            stringBuilder.append(preOrder(root.left));
        }
        stringBuilder.append(root.val).append(",");
        if (root.right != null) {
            stringBuilder.append(preOrder(root.right));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node5.left = node2;
        node5.right = node3;
        node2.left = node4;
        Solution solution = new Solution();
        System.out.println(solution.maxValue(node5,2));
    }
}
