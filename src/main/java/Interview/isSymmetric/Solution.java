package Interview.isSymmetric;

import leetcode.Util.TreeNode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/5/10 3:37 PM
 * @Version: 1.initial version; 2022/5/10 3:37 PM
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        return root1.val == root2.val && dfs(root1.left, root2.right) &&
                dfs(root1.right, root2.left);
    }

    public static void main(String[] args) {
        Map<String, Boolean> map = new HashMap<>();
        map.put("test", null);
        map.put("hello",false);
        if(map.containsKey("test") && map.get("test")){
            System.out.println("nihao null");
        }
        System.out.println("hello world");
    }
}
