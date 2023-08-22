package aigo.max.Depth;

import aigo.POJO.TreeNode;

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
public class MaxDepthV2 extends MaxDepthSuper {
    @Override
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        //记录
        int leftMaxLevel = maxDepth(root.left);
        int rightMaxLevel = maxDepth(root.right);
        return Math.max(leftMaxLevel, rightMaxLevel) + 1;
    }



}
