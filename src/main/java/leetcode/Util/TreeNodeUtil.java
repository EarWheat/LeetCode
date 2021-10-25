package leetcode.Util;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-24 15:44
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class TreeNodeUtil {
    public static TreeNode array2TreeNode(int[] array){
        if(array.length <= 0){
            return new TreeNode();
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedBlockingDeque<>();
        queue.add(root);
        int i = 1;
        while (i < array.length && queue.size() != 0){
            TreeNode temp = queue.poll();
            if(array[i] != Integer.MIN_VALUE){
                temp.left = new TreeNode(array[i]);
                queue.add(temp.left);
            }
            i++;
            if(i >= array.length){
                break;
            } else {
                if(array[i] != Integer.MIN_VALUE){
                    temp.right = new TreeNode(array[i]);
                    queue.add(temp.right);
                }
                i++;
            }
        }

        return root;
    }
}
