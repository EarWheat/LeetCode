package leetcode.Eight.distanceK;

import com.alibaba.fastjson.JSONObject;
import leetcode.Util.TreeNode;


import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/7/28 2:08 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {

    private Map<TreeNode, TreeNode> fater = new HashMap<>();

    private Set<TreeNode> used = new HashSet<>();


    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<TreeNode> list = new ArrayList<>();
//        if(root == target){
//            if(root.left != null){
//                list.add(root.left);
//            }
//            if(root.right != null){
//                list.add(root.right);
//            }
//            getDistanceNode(list,target,k - 1);
//        }
        list = findTargetTreeNode(root,target);
        return getDistanceNode(list, target,k - 1);
    }

    public List<TreeNode> findTargetTreeNode(TreeNode root, TreeNode target){
        if(root == null){
            return null;
        }
        List<TreeNode> result = new ArrayList<>();
        if(root.left  == target){
            result.add(root);
            fater.put(target, root);
            if(target.left != null){
                result.add(target.left);
            }
            if(target.right != null){
                result.add(target.right);
            }
            return result;
        }
        if(root.right == target){
            fater.put(target, root);
            result.add(root);
            if(target.left != null){
                result.add(target.left);
            }
            if(target.right != null){
                result.add(target.right);
            }
            return result;
        }
        if(root.left != null){
            fater.put(root.left, root);
            if(!(result = findTargetTreeNode(root.left, target)).isEmpty()){
                return result;
            }
        }
        if(root.right != null){
            fater.put(root.right, root);
            if(!(result = findTargetTreeNode(root.right, target)).isEmpty()){
                return result;
            }
        }
        return result;
    }

    public List<Integer> getDistanceNode(List<TreeNode> list,TreeNode target, int k){
        if(k == 0){
            List<Integer> result = new ArrayList<>();
            for (TreeNode node : list) {
                result.add(node.val);
            }
            return result;
        }
        List<TreeNode> temp = new ArrayList<>();
        for (TreeNode node : list) {
            if(node.left != null && node.left != target && !used.contains(node.left)){
                used.add(node);
                temp.add(node.left);
            }
            if(node.right != null && node.right != target && !used.contains(node.right)){
                used.add(node);
                temp.add(node.right);
            }
            if(fater.containsKey(node) && !used.contains(node)){
                used.add(node);
                temp.add(fater.get(node));
            }
        }
        return getDistanceNode(temp, target, k - 1);
    }

//                  0
//                 / \
//                2   1
//                   /
//                  3
    // [0,2,1,null,null,3]
    //3
    //3
    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
//        node3.left = node5;
//        node3.right = node1;
//        node5.left = node6;
//        node5.right = node2;
//        node1.left = node0;
//        node1.right = node8;
//        node2.left = node7;
//        node2.right = node4;
        node0.left = node2;
        node0.right = node1;
        node1.left = node3;
        Solution solution = new Solution();
        System.out.println(JSONObject.toJSONString(solution.distanceK(node0,node3,3)));
    }
}
