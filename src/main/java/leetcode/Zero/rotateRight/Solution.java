package leetcode.Zero.rotateRight;

import com.alibaba.fastjson.JSONObject;
import leetcode.Util.ListNode;
import leetcode.Util.ListNodeUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/27 上午7:38
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0){
            return head;
        }
//        for (int i = 0; i < k; i++) {
//            ListNode preLastNode = head;    // 倒数第二个节点
//            while (preLastNode.next != null && preLastNode.next.next != null){
//                preLastNode = preLastNode.next;
//            }
//            head = transformNode(head,preLastNode);
//        }
//        return head;
        Map<Integer, ListNode> map = new HashMap<>();
        int index = 0;
        ListNode temp = head;
        while (temp != null){
            map.put(index,temp);
            temp = temp.next;
            index++;
        }
        int step = k % index;
        if(step == 0){
            return head;
        }
        ListNode newHead = map.get(index - step);
        ListNode preNewHed = map.get(index - step - 1);
        ListNode last = map.get(index - 1);
        preNewHed.next = null;
        last.next = head;
        return newHead;
    }

//    public ListNode transformNode(ListNode head, ListNode preLastNode){
//        ListNode lastNode = preLastNode.next;
//        lastNode.next = head;
//        preLastNode.next = null;
//        return lastNode;
//    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.array2ListNode(new int[]{1});
        Solution solution = new Solution();
        System.out.println(JSONObject.toJSONString(solution.rotateRight(head,1)));
    }
}
