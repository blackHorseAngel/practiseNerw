package aigo.POJO;

import java.util.Queue;

/**
 *@Desprition
 *@Author zhangshenming
 *@Date 2021/11/28 13:55
 *@Version 1.0
 */

public class TreeNode {
    /***
     * 每个树节点的值
     */
    int value;
    //左节点
    public TreeNode left;
    //右节点
    public TreeNode right;

    public TreeNode() {
    }
    /**
     * @Description 初始化方法
     * @Author zhangshenming
     * @Param val
     * @Date 2021/11/28 15:43
     * @Return
     */
    public TreeNode(int val) {
        value = val;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    /**
     * 打印树
     * @param treeNode
     * @param queue
     */
    public static void layerPriorityTraverseTree(TreeNode treeNode, Queue<TreeNode> queue){
        queue.offer(treeNode);
        while(!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            System.out.print(curNode.getValue()+"  ");
            if(curNode.left != null){
                queue.offer(curNode.left);
            }
            if(curNode.right != null){
                queue.offer(curNode.right);
            }
        }
    }

    public static void main(String[] args) {


    }
}
