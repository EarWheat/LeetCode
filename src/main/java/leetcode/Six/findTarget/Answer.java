package leetcode.Six.findTarget;

import leetcode.Util.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：liuzhaolu
 * @description：TODO
 * @prd :
 * @date ：2022/3/21 5:00 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/21 5:00 下午     liuzhaolu       firstVersion
 */
public class Answer {
    Set<Integer> set = new HashSet<Integer>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

}
