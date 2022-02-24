package coding.Tree.RuleTree;

import com.alibaba.fastjson.JSONObject;
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
        List<Node> temp = roots;
        while (true){
            String feature = features.poll();
            for (Node node : temp) {
                if (node.val.equalsIgnoreCase(feature)) {
                    List<Node> child = node.child;
                    feature = features.poll();
                }
            }
        }
//            for(Node child : node.child){
//                if(child.val.equals(feature)){
//                    addFeatureRecord(node.child, features);
//                } else {
//                    node.child.addAll(initTree(features));
//                }
//            }
    }

    public void printTree(List<Node> temp) {
        while (temp != null) {
            for (Node node : temp) {
                System.out.print(node.val + "-");
                printTree(node.child);
            }
        }
    }

    public static void main(String[] args) {
        String record1 = "{\"life_cycle_code\":\"D_STRIVE_ORDER\",\"exec_code\":\"SUCCESS\",\"punish_rule_id\":\"\",\"role\":\"DRV\",\"gp_code\":\"D0401\",\"punish_level\":\"\",\"duty_result\":\"\",\"intercept_result\":\"\",\"punish_type\":\"\",\"canonical_country_code\":\"RU\",\"product_id\":\"21011\",\"hit_strategy_code\":\"VERSION_CONTROL\",\"scene_code\":\"\",\"hit_intercept_code\":\"\",\"city_id\":7380100,\"timestamp\":1645608258907,\"punish_duration\":\"\"}";
        String record2 = "{\"life_cycle_code\":\"D_STRIVE_ORDER\",\"exec_code\":\"SUCCESS\",\"punish_rule_id\":\"\",\"role\":\"DRV\",\"gp_code\":\"D0401\",\"punish_level\":\"\",\"duty_result\":\"\",\"intercept_result\":\"\",\"punish_type\":\"\",\"canonical_country_code\":\"RU\",\"product_id\":\"21011\",\"hit_strategy_code\":\"WITHOUT_SUPPLY\",\"scene_code\":\"\",\"hit_intercept_code\":\"\",\"city_id\":7490100,\"timestamp\":1645608259518,\"punish_duration\":\"\"}";
        String record3 = "{\"life_cycle_code\":\"D_STRIVE_ORDER\",\"exec_code\":\"SUCCESS\",\"punish_rule_id\":\"\",\"role\":\"DRV\",\"gp_code\":\"D0401\",\"punish_level\":\"\",\"duty_result\":\"\",\"intercept_result\":\"\",\"punish_type\":\"\",\"canonical_country_code\":\"RU\",\"product_id\":\"21011\",\"hit_strategy_code\":\"WITHOUT_SUPPLY\",\"scene_code\":\"\",\"hit_intercept_code\":\"\",\"city_id\":7380100,\"timestamp\":1645608262778,\"punish_duration\":\"\"}";
        String record4 = "{\"life_cycle_code\":\"D_STRIVE_ORDER\",\"exec_code\":\"SUCCESS\",\"punish_rule_id\":\"\",\"role\":\"DRV\",\"gp_code\":\"D0401\",\"punish_level\":\"\",\"duty_result\":\"\",\"intercept_result\":\"\",\"punish_type\":\"\",\"canonical_country_code\":\"RU\",\"product_id\":\"21011\",\"hit_strategy_code\":\"VERSION_CONTROL\",\"scene_code\":\"\",\"hit_intercept_code\":\"\",\"city_id\":7810200,\"timestamp\":1645608264837,\"punish_duration\":\"\"}";
        RuleTree ruleTree = new RuleTree();
//        ruleTree.addFeatureRecord(ruleTree.fakeHead, featureProcess(record1));
//        ruleTree.addFeatureRecord(ruleTree.fakeHead, featureProcess(record2));
//        ruleTree.addFeatureRecord(ruleTree.fakeHead, featureProcess(record3));
//        ruleTree.addFeatureRecord(ruleTree.fakeHead, featureProcess(record4));
//        ruleTree.printTree(ruleTree.root);
    }

    public static LinkedList<String> featureProcess(String s) {
        JSONObject jsonObject = JSONObject.parseObject(s);
        LinkedList<String> result = new LinkedList<>();
        result.add(jsonObject.getString("life_cycle_code"));
        result.add(jsonObject.getString("role"));
        result.add(jsonObject.getString("gp_code"));
        result.add(jsonObject.getString("canonical_country_code"));
        result.add(jsonObject.getString("product_id"));
        result.add(jsonObject.getString("city_id"));
        result.add(jsonObject.getString("hit_strategy_code"));
        return result;
    }
}
