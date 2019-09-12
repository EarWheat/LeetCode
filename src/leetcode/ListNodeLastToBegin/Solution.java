package leetcode.ListNodeLastToBegin;

import UtilClass.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/*
 * @author:liuzhaolu
 * @createTime: 2019-09-12 16:43
 * @desc:输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        if(listNode == null){
            return arrayList;
        }
        while (listNode.next != null){
            int i = listNode.data;
            stack.push(i);
            listNode = listNode.next;
        }
        stack.push(listNode.data);
        while (!stack.empty()){
            int i = stack.pop();
            arrayList.add(i);
        }
        return arrayList;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.printListFromTailToHead(null);
    }
}
