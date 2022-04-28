package coding.Tree.RuleTree;

import com.alibaba.fastjson.JSONObject;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author ：liuzhaolu
 * @description：规则树
 * @prd :
 * @date ：2022/2/21 1:58 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/2/21 1:58 下午     liuzhaolu       firstVersion
 */

public class RuleTree {
//    /**
//     * 虚假头节点
//     */
//    Node fakeHead = new Node();
    /**
     * 当前节点
     */
    List<Node> roots;

    public static class Node {
        /**
         * 当前值
         */
        String val;
//        /**
//         * 下一个节点指针
//         */
//        Node next;
        /**
         * 子节点
         */
        List<Node> child;
    }


    /**
     * 根据任意一条特征记录初始化
     *
     * @param features
     */
    public RuleTree(LinkedList<String> features) {
//        fakeHead.child = initTree(features);
    }

    /**
     * 构建树
     *
     * @param features
     * @return
     */
    private List<Node> initTree(LinkedList<String> features) {
        if (features.size() <= 0) {
            return null;
        }
        List<Node> result = new ArrayList<>();
        Node head = new Node();
        head.val = features.poll();
        head.child = initTree(features);
        result.add(head);
        return result;
    }


    public void addFeatureRecord(LinkedList<String> features) {
        if (features.size() < 1) {
            return;
        }
        // 没有初始化的话，进行初始化
        if (Objects.isNull(roots)) {
            roots = initTree(features);
            return;
        }
        String feature = features.poll();
        for (Node node : roots) {
            if (node.val.equalsIgnoreCase(feature)) {
                while (node.child != null){
                    feature = features.poll();
                    boolean matched = false;
                    for (Node childNode : node.child){
                        if(childNode.val.equalsIgnoreCase(feature)){
                            node = childNode;
                            matched = true;
                            break;
                        }
                    }
                    if(!matched){
                        // 遍历完都不相等
                        features.add(0, feature);
                        List<Node> newBranch = initTree(features);
                        if(newBranch != null){
                            node.child.addAll(newBranch);
                            break;
                        }
                    }
                }
            } else {
                // 新分支
                List<Node> newBranch = initTree(features);
                if(newBranch != null){
                    roots.addAll(newBranch);
                }
            }
        }
    }

    public List<String> printTree(List<Node> temp) {
        List<String> result = new ArrayList<>();
        if(temp == null){
            result.add("");
            return result;
        }
        for (Node node : temp) {
            if(node.val != null){
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(node.val);
                List<String> str = printTree(node.child);
                if(str != null){
                    for(String s : str){
                        result.add(stringBuilder + " - " + s);
                    }
                }
            }
        }
        return result;
    }

}
