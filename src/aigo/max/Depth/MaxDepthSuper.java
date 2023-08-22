package aigo.max.Depth;

import aigo.POJO.TreeNode;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/7/4 14:16
 * @Version 1.0.0
 */
public class MaxDepthSuper {
    public int maxDepth(TreeNode root) {
        return 0;
    }
    public static void main(String[] args) {
        //{3,9,20,null,null,15,7}  3
        TreeNode root = new TreeNode(3);
        TreeNode leftNode = new TreeNode(9);
        root.setLeft(leftNode);
        TreeNode rightNodeNew = new TreeNode(20);
        root.setRight(rightNodeNew);
        TreeNode leftNode2 = new TreeNode(15);
        rightNodeNew.setLeft(leftNode2);
        TreeNode rightNode2 = new TreeNode(7);
        rightNodeNew.setRight(rightNode2);

        //{0,2,4,1,null,3,-1,5,1,null.6.null,8}  4
        TreeNode root1 = new TreeNode(0);
        TreeNode leftNode11 = new TreeNode(2);
        root1.setLeft(leftNode11);
        TreeNode rightNode11 = new TreeNode(4);
        root1.setRight(rightNode11);
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
        TreeNode root2 = new TreeNode(1);
        TreeNode rightNode = new TreeNode(2);
        root2.setRight(rightNode);

        //{-8,-6,7,6,null,null,null,null,5}  4
        TreeNode root3 = new TreeNode(-8);
        TreeNode leftNode10 = new TreeNode(-6);
        TreeNode rightNode10 = new TreeNode(7);
        root3.setLeft(leftNode10);
        root3.setRight(rightNode10);
        TreeNode leftNode20 = new TreeNode(6);
        leftNode10.setLeft(leftNode20);
        TreeNode rightNode31 = new TreeNode(5);
        leftNode20.setRight(rightNode31);
        //new MaxDepthV1(),new MaxDepthV2(),
        MaxDepthSuper[]maxDepthSupers = {new MaxDepthV3()};
        TreeNode[]roots = {root,root1,root2,root3};
        for(TreeNode node:roots){
            for(MaxDepthSuper maxDepthSuper:maxDepthSupers){
                System.out.println(maxDepthSuper.maxDepth(node));
            }
        }
    }
}
