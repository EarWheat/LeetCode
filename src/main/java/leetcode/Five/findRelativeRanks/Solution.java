package leetcode.Five.findRelativeRanks;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：liuzhaolu
 * @description：TODO
 * @prd :
 * @date ：2021/12/2 3:50 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2021/12/2 3:50 下午     liuzhaolu       firstVersion
 */
public class Solution {
    class Node{
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    public String[] findRelativeRanks(int[] score) {
        Node head = null;
        for (int i = 0; i < score.length; i++) {
            if(head == null){
                head = new Node(score[i]);
            } else {
                Node temp = new Node(score[i]);
                // 当前值比头结点大
                if(temp.val > head.val){
                    temp.next = head;
                    head = temp;
                } else {
                    // 插入
                    Node index = head;
                    while (index.next != null){
                        if(temp.val > index.next.val){
                            temp.next = index.next;
                            index.next = temp;
                            break;
                        }
                        index = index.next;
                    }
                    index.next = temp;
                }
            }
        }
        int r = 1;
        Map<Integer,String> rank = new HashMap<>();
        while (head != null){
            String rankName = String.valueOf(r);
            if(r == 1){
                rankName = "Gold Medal";
            }
            if(r == 2){
                rankName = "Silver Medal";
            }
            if(r == 3){
                rankName = "Bronze Medal";
            }
            rank.put(head.val, rankName);
            head = head.next;
            r++;
        }
        String[] result = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            result[i] = rank.get(score[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] score = new int[]{5,4,3,2,1};
        Solution solution = new Solution();
        System.out.println(solution.findRelativeRanks(score).toString());
    }
}
