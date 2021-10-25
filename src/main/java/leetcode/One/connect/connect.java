package leetcode.One.connect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-10-15 16:27
 * @desc
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *  
 *
 * 示例：
 *
 *
 *
 * 输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 *
 * 输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}
 *
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class connect {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public static Node connect(Node root) {
        Queue<Node> queue = new LinkedBlockingDeque<>();
        queue.add(root);
        connectNode(queue);
        return root;
    }

    public static void connectNode(Queue<Node> queue){
        if(queue.size() == 0){
            return;
        }
        Queue<Node> newQ = new LinkedBlockingDeque<>();
        Node head = queue.poll(); // 该层头节点
        if(head == null){
            return;
        }
        if(head.left!= null){
            newQ.add(head.left);
        }
        if(head.right != null){
            newQ.add(head.right);
        }
        while (queue.size() > 0){
            Node temp = queue.poll();
            head.next = temp;
            head = temp;
            if(temp.left != null){
                newQ.add(temp.left);
            }
            if(temp.right != null){
                newQ.add(temp.right);
            }
        }
        connectNode(newQ);
    }

    public static void main(String[] args) {
        String s = "{\"$id\":\"1\",\"left\":{\"$id\":\"2\",\"left\":{\"$id\":\"3\",\"left\":null,\"next\":null,\"right\":null,\"val\":4},\"next\":null,\"right\":{\"$id\":\"4\",\"left\":null,\"next\":null,\"right\":null,\"val\":5},\"val\":2},\"next\":null,\"right\":{\"$id\":\"5\",\"left\":{\"$id\":\"6\",\"left\":null,\"next\":null,\"right\":null,\"val\":6},\"next\":null,\"right\":{\"$id\":\"7\",\"left\":null,\"next\":null,\"right\":null,\"val\":7},\"val\":3},\"val\":1}";
        JSONObject jsonObject = JSON.parseObject(s);
        Node root = formatNode(jsonObject);
        Node newNode = connect(root);
        System.out.println(newNode.val);
    }

    private static Node formatNode(JSONObject jsonObject){
        Node root = new Node(jsonObject.getInteger("val"));
        root.next = null;
        if(jsonObject.get("left") != null){
            root.left = formatNode(jsonObject.getJSONObject("left"));
        }
        if(jsonObject.get("right") != null){
            root.right = formatNode(jsonObject.getJSONObject("right"));
        }
        return root;
    }
}
