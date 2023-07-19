package Aigo.Symmetric;

import Aigo.POJO.TreeNode;

/**
 * @Description https://leetcode.cn/problems/symmetric-tree/
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 * @Author Administrator
 * @Date 2023/7/5 12:21
 * @Version 1.0.0
 */
public class SymmetricV1 extends SymmetricSuper{
    @Override
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        boolean leftFlag = isSymmetric(root.left);
        boolean rightFlag = isSymmetric(root.right);

        return leftFlag && rightFlag;
    }

    public static void main(String[] args) {
        SymmetricV1 symmetricV1= new SymmetricV1();
        //[1,2,2,3,4,4,3] true
//        TreeNode root = new TreeNode(1);
//        TreeNode leftNode10 = new TreeNode(2);
//        TreeNode rightNode11 = new TreeNode(2);
//        root.setLeft(leftNode10);
//        root.setRight(rightNode11);
//        TreeNode leftNode20 = new TreeNode(3);
//        TreeNode rightNode21 = new TreeNode(4);
//        leftNode10.setLeft(leftNode20);
//        leftNode10.setRight(rightNode21);
//        TreeNode leftNode22 = new TreeNode(4);
//        TreeNode rightNode23 = new TreeNode(3);
//        rightNode11.setLeft(leftNode22);
//        rightNode11.setRight(rightNode23);
        //[1,2,2,null,3,null,3] false
        TreeNode root = new TreeNode(1);
        TreeNode leftNode10 = new TreeNode(2);
        TreeNode rightNode11 = new TreeNode(2);
        root.setLeft(leftNode10);
        root.setRight(rightNode11);
        TreeNode rightNode21 = new TreeNode(3);
        leftNode10.setRight(rightNode21);
        TreeNode rightNode23 = new TreeNode(3);
        rightNode11.setRight(rightNode23);

        boolean flag = symmetricV1.isSymmetric(root);
        System.out.println(flag);
    }
}
