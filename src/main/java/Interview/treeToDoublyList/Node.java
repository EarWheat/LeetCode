package Interview.treeToDoublyList;

/**
 * @author ：liuzhaolu
 * @description：
 * @prd :
 * @date ：2022/4/21 3:17 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/4/21 3:17 下午     liuzhaolu       firstVersion
 */
public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
