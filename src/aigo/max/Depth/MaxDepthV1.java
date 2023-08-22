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
    * 分别查找根元素的左边的根节点的最深度和右边的根节点的最深度进行比较，返回最深的那个再加1(根节点自己)
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
}
