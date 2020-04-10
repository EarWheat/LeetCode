package coding.Tree.TreeTest;

import coding.Tree.Tree;
import coding.Tree.TreeBase.TreeBase;

/*
 * @author:liuzhaolu
 * @createTime: 2020-04-10 15:07
 * @desc:
 */
public class BuildTree extends TreeBase {
    public static void main(String[] args) {
       BuildTree buildTree = new BuildTree();
       Tree root = buildTree.buildTree();
       buildTree.showTree(root);
    }

}
