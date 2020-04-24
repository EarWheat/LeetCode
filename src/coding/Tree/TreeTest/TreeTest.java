package coding.Tree.TreeTest;

import UtilClass.Tree;
import coding.Tree.TreeBase.TreeBase;

/*
 * @author:liuzhaolu
 * @createTime: 2020-04-22 20:04
 * @desc:
 */
public class TreeTest extends TreeBase {
    public static void main(String[] args) {
        TreeBase.Tree root = buildTree(2);
        showTree(root);
    }
}
