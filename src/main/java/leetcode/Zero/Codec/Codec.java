package leetcode.Zero.Codec;

import leetcode.Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/6/30 下午10:50
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "null,";
        }
        String res = root.val + ",";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        Queue<String> queue = new LinkedList<String>();
        for(int i = 0; i < arr.length; i++){
            queue.offer(arr[i]);
        }
        return help(queue);
    }

    public TreeNode help(Queue<String> queue){
        String val = queue.poll();
        if(val.equals("null")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = help(queue);
        root.right = help(queue);
        return root;
    }
}
