package Aigo.Same.Tree;

import Aigo.POJO.TreeNode;

/**
 * @Description https://leetcode.cn/problems/same-tree
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -104 <= Node.val <= 104
 * @Author Administrator
 * @Date 2023/7/4 19:57
 * @Version 1.0.0
 */
public class SameTreeV1 extends SameTreeSuper {
    @Override
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.getValue() != q.getValue()) {
            return false;
        }
        boolean flagLeft = isSameTree(p.left, q.left);
        boolean flagRight = isSameTree(p.right, q.right);
        return flagLeft && flagRight;
    }

    public static void main(String[] args) {
        SameTreeV1 sameTreeV1 = new SameTreeV1();
        //p = [1,2,3], q = [1,2,3]
        TreeNode pRoot = new TreeNode(1);
        TreeNode pLeftNode11 = new TreeNode(2);
        pRoot.setLeft(pLeftNode11);
        TreeNode pRightNode12 = new TreeNode(3);
        pRoot.setRight(pRightNode12);
        TreeNode qRoot = new TreeNode(1);
        TreeNode qLeftNode11 = new TreeNode(2);
        qRoot.setLeft(qLeftNode11);
        TreeNode qRightNode12= new TreeNode(3);
        qRoot.setRight(qRightNode12);
        //p = [1,2], q = [1,null,2] false
//        TreeNode pRoot = new TreeNode(1);
//        TreeNode pLeftNode = new TreeNode(2);
//        pRoot.setLeft(pLeftNode);
//        TreeNode qRoot = new TreeNode(1);
//        TreeNode qRightNode = new TreeNode(2);
//        qRoot.setRight(qRightNode);
        //p = [1,2,1], q = [1,1,2] false
//        TreeNode pRoot = new TreeNode(1);
//        TreeNode pLeftNode = new TreeNode(2);
//        TreeNode pRighNode = new TreeNode(1);
//        pRoot.setLeft(pLeftNode);
//        pRoot.setRight(pRighNode);
//        TreeNode qRoot = new TreeNode(1);
//        TreeNode qLeftNode = new TreeNode(1);
//        TreeNode qRightNode = new TreeNode(2);
//        qRoot.setLeft(qLeftNode);
//        qRoot.setRight(qRightNode);
        //p=[],q=[], true
//        TreeNode pRoot = null;
//        TreeNode qRoot = null;
        //p=[1] q=[1,null,2] false
//        TreeNode pRoot = new TreeNode(1);
//        TreeNode qRoot = new TreeNode(1);
//        TreeNode qRightNode = new TreeNode(2);
//        qRoot.setRight(qRightNode);

        boolean flag = sameTreeV1.isSameTree(pRoot, qRoot);
        System.out.println(flag);
    }
}
