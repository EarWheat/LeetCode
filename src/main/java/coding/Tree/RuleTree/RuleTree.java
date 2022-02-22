package coding.Tree.RuleTree;

import lombok.NoArgsConstructor;

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

@NoArgsConstructor
public class RuleTree {
    /**
     * 当前节点
     */
    Node root;

    public static class Node{
        /**
         * 当前值
         */
        Object val;
        /**
         * 下一个节点指针
         */
        Node next;
        /**
         * 子节点
         */
        Node child;
    }

    public RuleTree(Node root) {
        this.root = root;
    }

    /**
     * 根据任意一条特征记录初始化
     * @param features
     */
    public RuleTree(LinkedList<Object> features){
        root = initTree(features);
    }

    /**
     * 构建树
     * @param features
     * @return
     */
    private Node initTree(LinkedList<Object> features){
        Node result = new Node();
        result.val = features.poll();
        result.child = initTree(features);
        return result;
    }



    public void addFeatureRecord(Node root, LinkedList<Object> features){
        if(features.size() < 1){
            return;
        }
        // 没有初始化的话，进行初始化
        if(Objects.isNull(root)){
            initTree(features);
            return;
        }
        Object feature = features.poll();
        Node temp = root;
        while (temp != null){
            if(temp.val == feature){
                addFeatureRecord(temp.child, features);
                break;
            } else {
                temp = temp.next;
            }
        }
    }
}
