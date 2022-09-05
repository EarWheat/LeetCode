package leetcode.Six.findDuplicateSubtrees;

import leetcode.Util.TreeNode;

import java.util.*;

/**
 * @Desc: 652 寻找重复的子树
 * @Author: 泽露
 * @Date: 2022/9/5 2:13 PM
 * @Version: 1.initial version; 2022/9/5 2:13 PM
 */
public class Solution {
    // 序列化 + hash过滤树结构
    Map<String, TreeNode> seen = new HashMap<String, TreeNode>();
    Set<TreeNode> repeat = new HashSet<TreeNode>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<TreeNode>(repeat);
    }

    public String dfs(TreeNode node) {
        if (node == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        sb.append("(");
        sb.append(dfs(node.left));
        sb.append(")(");
        sb.append(dfs(node.right));
        sb.append(")");
        String serial = sb.toString();
        if (seen.containsKey(serial)) {
            repeat.add(seen.get(serial));
        } else {
            seen.put(serial, node);
        }
        return serial;
    }

}
