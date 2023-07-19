package Aigo.Reverse.Tree;

import Aigo.POJO.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static Aigo.POJO.TreeNode.layerPriorityTraverseTree;

/**
 * @Description https://leetcode.cn/problems/invert-binary-tree
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 * 输入：root = []
 * 输出：[]
 * 树中节点数目范围在 [0, 100] 内
 * -100 <= Node.val <= 100
 * @Author Administrator
 * @Date 2023/7/5 9:59
 * @Version 1.0.0
 */
public class ReverseTreeV1 extends ReverseTreeSuper{
    @Override
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        //翻转左边
      TreeNode leftNode = invertTree(root.left);
        //翻转右边
        TreeNode rightNode = invertTree(root.right);
        root.setLeft(rightNode);
        root.setRight(leftNode);
        return root;
    }

    public static void main(String[] args) {
        ReverseTreeV1 reverseTreeV1 = new ReverseTreeV1();
        //[4,2,7,1,3,6,9]   result:[4,7,2,9,6,3,1]
//        TreeNode root = new TreeNode(4);
//        TreeNode leftNode10 = new TreeNode(2);
//        TreeNode rightNode11 = new TreeNode(7);
//        root.setLeft(leftNode10);
//        root.setRight(rightNode11);
//        TreeNode leftNode20 = new TreeNode(1);
//        TreeNode rightNode21 = new TreeNode(3);
//        leftNode10.setLeft(leftNode20);
//        leftNode10.setRight(rightNode21);
//        TreeNode leftNode22 = new TreeNode(6);
//        TreeNode rightNode23 = new TreeNode(9);
//        rightNode11.setLeft(leftNode22);
//        rightNode11.setRight(rightNode23);
        //[2,1,3] result:[2,3,1]
        TreeNode root = new TreeNode(2);
        TreeNode leftNode = new TreeNode(1);
        TreeNode rightNode = new TreeNode(3);
        root.setLeft(leftNode);
        root.setRight(rightNode);
        //[] result:[]
//        TreeNode root = null;
        TreeNode node = reverseTreeV1.invertTree(root);
        Queue<TreeNode> queue = new LinkedList<>();
        layerPriorityTraverseTree(node,queue);

    }
}
