package leetcode.Two.countNodes;

import leetcode.Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-24 15:16
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class countNodes {
    public int countNodes(TreeNode root) {
        int count = 0;
        if(root != null){
            count++;
        }
        List<TreeNode> list = new ArrayList<>();
        if(root.left != null){
            list.add(root.left);
        }
        if(root.right != null){
            list.add(root.right);
        }
        for(TreeNode treeNode : list){
            count += countNodes(treeNode);
        }
        return count;
    }



}
