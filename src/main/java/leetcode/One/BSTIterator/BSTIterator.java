package leetcode.One.BSTIterator;

import leetcode.Util.ListNode;
import leetcode.Util.ListNodeUtil;
import leetcode.Util.TreeNode;
import leetcode.Util.TreeNodeUtil;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/28 上午8:12
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class BSTIterator {

    private List<Integer> list = new ArrayList<Integer>();
    private int index = 0;

    public BSTIterator(TreeNode root) {
        buildList(root);
    }

    public int next() {
        int result = list.get(index);
        index++;
        return result;
    }

    public boolean hasNext() {
        return index < list.size();
    }

    public void buildList(TreeNode root){
        if(root.left != null){
            buildList(root.left);
        }
        list.add(root.val);
        if(root.right != null){
            buildList(root.right);
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        TreeNode node3 = new TreeNode(3);
        TreeNode node15 = new TreeNode(15);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        root.left = node3;
        root.right = node15;
        node15.left = node9;
        node15.right = node20;
        BSTIterator bSTIterator = new BSTIterator(root);
        bSTIterator.next();    // 返回 3
        bSTIterator.next();    // 返回 7
        bSTIterator.hasNext(); // 返回 True
        bSTIterator.next();    // 返回 9
        bSTIterator.hasNext(); // 返回 True
        bSTIterator.next();    // 返回 15
        bSTIterator.hasNext(); // 返回 True
        bSTIterator.next();    // 返回 20
        bSTIterator.hasNext(); // 返回 False
    }
}
