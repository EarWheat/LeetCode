package leetcode.Eight.constructFromPrePost;

import leetcode.Util.TreeNode;

import java.util.Arrays;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2024/2/22 2:40 PM
 * @Version: 1.initial version; 2024/2/22 2:40 PM
 */
public class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int N = pre.length;
        if (N == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        if (N == 1) {
            return root;
        }

        int L = 0;
        for (int i = 0; i < N; ++i) {
            if (post[i] == pre[1]) {
                L = i+1;
            }
        }

        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, L+1),
                Arrays.copyOfRange(post, 0, L));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, L+1, N),
                Arrays.copyOfRange(post, L, N-1));
        return root;
    }
}
