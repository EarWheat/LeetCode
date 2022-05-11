package leetcode.Four.Codec;

import leetcode.Util.TreeNode;
import leetcode.Util.TreeNodeUtil;

import java.util.*;

/**
 * @Desc: 449. 序列化和反序列化二叉搜索树
 * @Author: 泽露
 * @Date: 2022/5/11 11:33 AM
 * @Version: 1.initial version; 2022/5/11 11:33 AM
 */
public class Codec {

    // Encodes a tree to a single string.
    // v|1|3|5|9|11|12|13|15|
    // 5-0|
    //          5
    //         /
    //        1
    //         \
    //          3
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        StringBuilder resp = new StringBuilder();
        int level = 0;
        while (!queue.isEmpty()){
            Queue<TreeNode> newQ = new ArrayDeque<>();
            while (!queue.isEmpty()){
                TreeNode temp = queue.poll();
                resp.append(level).append("-").append(temp.val).append("|");
                if(temp.left != null){
                    newQ.add(temp.left);
                }
                if(temp.right != null){
                    newQ.add(temp.right);
                }
            }
            queue = newQ;
            level++;
        }
        return resp.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0){
            return null;
        }
        String[] nodes = data.split("\\|");
        Map<Integer, List<TreeNode>> nodeMap = new HashMap<>(); // <level, List<value>>
        int maxLevel = 0;
        for(String node : nodes){
            int level = Integer.parseInt(node.split("-")[0]);
            int value = Integer.parseInt(node.split("-")[1]);
            if(nodeMap.containsKey(level)){
                nodeMap.get(level).add(new TreeNode(value));
            } else {
                maxLevel = Math.max(maxLevel, level);
                List<TreeNode> list = new ArrayList<>();
                list.add(new TreeNode(value));
                nodeMap.put(level, list);
            }
        }
        TreeNode root = nodeMap.get(0).get(0);
        Map<TreeNode, TreeNode> nodeParent = new HashMap<>();
        for (int i = 1; i <= maxLevel; i++) {
            List<TreeNode> parentNodes = nodeMap.get(i - 1);
            for(TreeNode parentNode: parentNodes){
                for(TreeNode node: nodeMap.get(i)){
                    if(nodeParent.containsKey(node)){
                        continue;
                    }
                    if(node.val < parentNode.val){
                        parentNode.left = node;
                        nodeParent.put(node, parentNode);
                    } else { // 大于父节点
                        TreeNode ppNode = nodeParent.get(parentNode);// 父亲的父亲节点
                        if(Objects.nonNull(ppNode) && node.val < ppNode.val){
                            parentNode.right = node;
                            nodeParent.put(node,parentNode);
                        }
                        if(parentNode == parentNodes.get(parentNodes.size() - 1)){
                            parentNode.right = node;
                            nodeParent.put(node,parentNode);
                        }
                    }
                }
            }
        }
        return root;
    }

    //       5
    //      / \
    //     3   12
    //    /   / \
    //   1   9   15
    //        \  /
    //        11 13
    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node12 = new TreeNode(12);
        TreeNode node9 = new TreeNode(9);
        TreeNode node15 = new TreeNode(15);
        TreeNode node13 = new TreeNode(13);
        TreeNode node11 = new TreeNode(11);
        node5.left = node3;
        node3.left = node1;
        node5.right = node12;
        node12.left = node9;
        node9.right = node11;
        node12.right = node15;
        node15.left = node13;
        System.out.println(codec.serialize(node5));
        TreeNode node = codec.deserialize(codec.serialize(node5));
        System.out.println(node.val);
    }
}
