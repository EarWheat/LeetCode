package UtilClass;

/**
 * @author liuzhaolu
 * @version create_time：2018/9/1 类说明:
 */
public class ListNode {
    public int data;
    public ListNode next = null;
    public ListNode(int x) { this.data = x; }

    ListNode head = null;
    /**
     * 链表添加结点:
     * 找到链表的末尾结点，把新添加的数据作为末尾结点的后续结点
     * @param data
     */
    public void addNode(int data){
        ListNode newNode = new ListNode(data);
        if(head == null){
            head = newNode;
            return;
        }
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

}
