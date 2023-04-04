package Aigo;

import Aigo.POJO.TreeNode;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/4/1 23:08
 * @Version 1.0.0
 */
public class PrefaceTravelsal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left11 = new TreeNode(2);
        root.setLeft(left11);
        TreeNode right11 = new TreeNode(3);
        root.setRight(right11);

    }
}
