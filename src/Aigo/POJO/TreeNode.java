package Aigo.POJO;

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
    TreeNode left;
    //右节点
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    /**
     * 每个节点的下面的子节点数
     */
//    List<TreeNode> nextTreeNodes = new ArrayList<TreeNode>();

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

    public static void main(String[] args) {


    }
}
