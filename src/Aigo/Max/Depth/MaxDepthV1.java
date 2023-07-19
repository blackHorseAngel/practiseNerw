package Aigo.Max.Depth;

import Aigo.POJO.TreeNode;

/**
 * @Description https://leetcode.cn/problems/maximum-depth-of-binary-tree
 * 给定一个二叉树，找出其最大深度。二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明:叶子节点是指没有子节点的节点。
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度3 。
 * @Author Administrator
 * @Date 2023/7/4 14:18
 * @Version 1.0.0
 */
public class MaxDepthV1 extends MaxDepthSuper {
    @Override
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //记录
        int[] count = new int[1];
        findDepth(root, count);
        return count[0];
    }

   /**
    *
     * @param node
     * @param count
     */
    private void findDepth(TreeNode node, int[]count) {
        if(node == null){
            count[0] = 0;
            return;
        }

        //记录
        int[] leftCount = new int[1];
        findDepth(node.left, leftCount);
        int[]rightCount = new int[1];
        findDepth(node.right,rightCount);
        count[0] = Math.max(leftCount[0], rightCount[0]) + 1;

    }

    public static void main(String[] args) {
        MaxDepthV1 maxDepthV1 = new MaxDepthV1();

        //{3,9,20,null,null,15,7}  3

//        TreeNode root = new TreeNode(3);
//        TreeNode leftNode = new TreeNode(9);
//        root.setLeft(leftNode);
//        TreeNode rightNode = new TreeNode(20);
//        root.setRight(rightNode);
//        TreeNode leftNode2 = new TreeNode(15);
//        rightNode.setLeft(leftNode2);
//        TreeNode rightNode2 = new TreeNode(7);
//        rightNode.setRight(rightNode2);

        //{0,2,4,1,null,3,-1,5,1,null.6.null,8}  4

        TreeNode root = new TreeNode(0);
        TreeNode leftNode11 = new TreeNode(2);
        root.setLeft(leftNode11);
        TreeNode rightNode11 = new TreeNode(4);
        root.setRight(rightNode11);
        TreeNode leftNode21 = new TreeNode(1);
        leftNode11.setLeft(leftNode21);
        TreeNode leftNode22 = new TreeNode(3);
        rightNode11.setLeft(leftNode22);
        TreeNode rightNode22 = new TreeNode(-1);
        rightNode11.setRight(rightNode22);
        TreeNode leftNode32 = new TreeNode(5);
        leftNode21.setLeft(leftNode32);
        TreeNode rightNode32 = new TreeNode(1);
        leftNode21.setRight(rightNode32);
        TreeNode rightNode34 = new TreeNode(6);
        leftNode22.setRight(rightNode34);
        TreeNode rightNode44 = new TreeNode(8);
        rightNode22.setRight(rightNode44);

        //{1,null,2} 2
//        TreeNode root = new TreeNode(1);
//        TreeNode rightNode = new TreeNode(2);
//        root.setRight(rightNode);

        //{-8,-6,7,6,null,null,null,null,5}  4
//        TreeNode root = new TreeNode(-8);
//        TreeNode leftNode10 = new TreeNode(-6);
//        TreeNode rightNode10 = new TreeNode(7);
//        root.setLeft(leftNode10);
//        root.setRight(rightNode10);
//        TreeNode leftNode20 = new TreeNode(6);
//        leftNode10.setLeft(leftNode20);
//        TreeNode rightNode31 = new TreeNode(5);
//        leftNode20.setRight(rightNode31);

        int depth = maxDepthV1.maxDepth(root);
        System.out.println(depth);
    }
}
