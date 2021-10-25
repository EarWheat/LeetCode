package leetcode.One.copyRandomList;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/7/22 2:11 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {

    static class Node{
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public ConcurrentHashMap<Node, Node> map = new ConcurrentHashMap<>();

    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        if (map.containsKey(head)) {
            return map.get(head);
        }
        Node temp = new Node(head.val);
        map.put(head, temp);
        temp.random = copyRandomList(head.random);
        temp.next = copyRandomList(head.next);
        return temp;
    }

    public static void main(String[] args) {
        Node node7 = new Node(7);
        Node node13 = new Node(13);
        Node node11 = new Node(11);
        Node node10 = new Node(10);
        Node node1 = new Node(1);
        node7.next = node13;
        node13.next = node11;
        node11.next = node10;
        node10.next = node1;
        node13.random = node7;
        node11.random = node1;
        node10.random = node11;
        node1.random = node11;
        Solution solution = new Solution();
        System.out.println(solution.copyRandomList(node7).val);

    }

}
