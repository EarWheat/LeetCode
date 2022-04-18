package leetcode.Three.lexicalOrder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author ：liuzhaolu
 * @description：386. 字典序排数
 * @prd : https://leetcode-cn.com/problems/lexicographical-numbers/
 * @date ：2022/4/18 11:13 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/4/18 11:13 上午     liuzhaolu       firstVersion
 */
public class Solution {

    //           0
    //          / \
    //        1 2 3 4 5 6 7 8 9
    //
    private static class TreeNode {
        int val;
        PriorityQueue<TreeNode> child;

        public TreeNode(int val) {
            this.val = val;
        }


    }

    public static TreeNode root = new TreeNode(0);

    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            add(i);
        }
        System.out.println(root.val);
        return res;
    }

    public void add(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        TreeNode fatherNode = root;
        PriorityQueue<TreeNode> nodes = fatherNode.child;
        for (int i = 0; i < chars.length - 1; i++) {
            int temp = Character.getNumericValue(s.charAt(i));
            while (nodes != null) {
                for (TreeNode node : nodes) {
                    if (node.val == temp) {
                        nodes = node.child;
                        fatherNode = node;
                        break;
                    }
                }
            }
//            TreeNode node = new TreeNode(temp);
//            nodes = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
//            nodes.add(node);
//            fatherNode.child = nodes;
        }
        // 最后一个char
        int lastNum = Character.getNumericValue(s.charAt(chars.length - 1));
        if (nodes != null) {
            nodes.add(new TreeNode(lastNum));
        } else {
            TreeNode node = new TreeNode(lastNum);
            nodes = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
            nodes.add(node);
            fatherNode.child = nodes;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lexicalOrder(13));
    }
}
