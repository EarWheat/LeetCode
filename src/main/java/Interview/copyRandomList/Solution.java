package Interview.copyRandomList;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/5/31 10:28 AM
 * @Version: 1.initial version; 2022/5/31 10:28 AM
 */
public class Solution {
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    Set<Node> visitedNode = new HashSet<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        //map中存的是(原节点，拷贝节点)的一个映射
        Map<Node, Node> map = new HashMap<>();
        for (Node cur = head; cur != null; cur = cur.next) {
            map.put(cur, new Node(cur.val));
        }
        //将拷贝的新的节点组织成一个链表
        for (Node cur = head; cur != null; cur = cur.next) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
        }

        return map.get(head);
    }

    public static void main(String[] args) {
        Node node7 = new Node(7);
        Node node13 =new Node(13);
        Node node11 = new Node(11);
        Node node10 = new Node(10);
        Node node1 = new Node(1);
        node7.next = node13;
        node13.next = node11;
        node13.random = node7;
        node11.next = node10;
        node10.random = node11;
        node10.next = node1;
        node1.random = node7;
        Solution solution = new Solution();
        System.out.println(solution.copyRandomList(node7));
    }
}
